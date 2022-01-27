package com.yjlan.im.gateway.deliverer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.protobuf.MessageLite;
import com.yjlan.im.common.codec.MessageProtocolDecoder;
import com.yjlan.im.common.codec.MessageProtocolEncoder;
import com.yjlan.im.common.constants.Constant;
import com.yjlan.im.common.proto.SendDelivererRequest;
import com.yjlan.im.common.route.ChooseServerHandle;
import com.yjlan.im.common.route.RandomHandle;
import com.yjlan.im.common.utils.ChannelIdUtils;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.gateway.handler.GatewayDelivererHandler;

/**
 * @author yjlan
 * @version V1.0
 * @Description ImMessageManager的连接管理
 * @date 2022.01.26 08:50
 */
@Component
public class DelivererManager {
    
    @Value("${instance.code}")
    private String instanceCode;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DelivererManager.class);
    
    
    /**
     * uuid和分发系统对应的channel。key:dispatcher服务器的地址 value:channel
     */
    private static final Map<String, SocketChannel> GATEWAY_CONNECT_DELIVERER_MAP
            = new ConcurrentHashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);
    
    @PostConstruct
    public void init() {
        connectDeliverer();
    }
    
    private void connectDeliverer() {
        // 这里其实应该从zk读取所有的messagePush实例
        List<String> dispatcherList = new ArrayList<>();
        int port = 9004;
        String ip = "127.0.0.1";
        String messagePushServiceAddress = "127.0.0.1" + ":" + port;
        dispatcherList.add(messagePushServiceAddress);
        for (String s : dispatcherList) {
            EventLoopGroup threadGroup = new NioEventLoopGroup(0);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(threadGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        
                        @Override
                        protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel)
                                throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 一次解码器
                            pipeline.addLast(new ProtobufVarint32FrameDecoder());
                            pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                            // 二次解码器
                            pipeline.addLast(new MessageProtocolDecoder());
                            pipeline.addLast(new MessageProtocolEncoder());
                            pipeline.addLast(new GatewayDelivererHandler());
                        }
                    });
            // 尝试发起连接
            ChannelFuture channelFuture = bootstrap.connect(ip, port);
            // 给异步化的连接请求加入监听器
            channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
                if (channelFuture1.isSuccess()) {
                    SocketChannel socketChannel = (SocketChannel) channelFuture1.channel();
                    GATEWAY_CONNECT_DELIVERER_MAP.put(messagePushServiceAddress,
                            socketChannel);
                    LOGGER.info("已经跟deliverer系统建立连接,deliverer系统接入系统地址为：" + messagePushServiceAddress);
                    // 建立连接后，向deliverer发一条信息
                    SendDelivererRequest sendDelivererRequest = SendDelivererRequest
                            .newBuilder().setInstanceCode(instanceCode).build();
                    MessageProtocolUtils.sendMsg(socketChannel, sendDelivererRequest);
                } else {
                    channelFuture1.channel().close();
                    threadGroup.shutdownGracefully();
                }
            });
        }
    }
    
    
    /**
     * 选择一台服务器
     *
     * @param key 关键字（一般是ip地址+端口）
     */
    public String chooseServer(String key) {
        ChooseServerHandle chooseServerHandle = new RandomHandle();
        return chooseServerHandle.chooseServer(new ArrayList<>(GATEWAY_CONNECT_DELIVERER_MAP.keySet()), key);
    }
    
    
    /**
     * 返回一个channel
     *
     * @param server dispatcher的服务器地址
     * @return 返回一个channel
     */
    public SocketChannel getSocketChannel(String server) {
        return GATEWAY_CONNECT_DELIVERER_MAP.get(server);
    }
    
    
    /**
     * 转发请求到messagePush
     *
     * @param clientChannel 客户端的channel
     * @param request       认证请求
     */
    public void forwardToDeliverer(SocketChannel clientChannel, MessageLite request) {
        // 选择一台服务器
        String server = this.chooseServer(ChannelIdUtils.getChannelId(clientChannel));
        MessageProtocolUtils.sendMsg(getSocketChannel(server), request);
    }
    
    
    public void remove(SocketChannel socketChannel) {
        GATEWAY_CONNECT_DELIVERER_MAP.remove(ChannelIdUtils.getChannelId(socketChannel));
    }
}
