package com.yjlan.im.gateway.dispatcher;

import com.yjlan.im.common.codec.MessageProtocolDecoder;
import com.yjlan.im.common.codec.MessageProtocolEncoder;
import com.yjlan.im.common.constants.Constant;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.route.ChooseServerHandle;
import com.yjlan.im.common.route.RandomHandle;
import com.yjlan.im.common.utils.ChannelIdUtils;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.gateway.handler.GatewayDispatcherHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 管理和dispatcher的链接
 *
 * @author yjlan
 */
@Component
public class DispatcherManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherManager.class);

    /**
     * 保存和所有的dispatcher的连接
     */
    private static final List<String> CONNECT_DISPATCHER = new CopyOnWriteArrayList<>();

    /**
     * uuid和分发系统对应的channel。key:dispatcher服务器的地址
     * value:channel
     */
    private static final Map<String,SocketChannel> GATEWAY_CONNECT_DISPATCHER_MAP
            = new ConcurrentHashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);

    @PostConstruct
    public void init() {
        connectDispatcher();
    }

    private void connectDispatcher() {
        // 这里其实应该从zk读取所有的dispatcher实例
        List<String> dispatcherList = new ArrayList<>();
        int port = 9003;
        String ip = "127.0.0.1";
        String dispatcherAddress = "127.0.0.1" + ":" + port;
        dispatcherList.add(dispatcherAddress);
        for (String s : dispatcherList) {
            EventLoopGroup threadGroup = new NioEventLoopGroup(0);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(threadGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {

                        @Override
                        protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 一次解码器
                            pipeline.addLast(new ProtobufVarint32FrameDecoder());
                            pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                            // 二次解码器
                            pipeline.addLast(new MessageProtocolDecoder());
                            pipeline.addLast(new MessageProtocolEncoder());
                            pipeline.addLast(new GatewayDispatcherHandler());
                        }
                    });
            // 尝试发起连接
            ChannelFuture channelFuture = bootstrap.connect(ip, port);
            // 给异步化的连接请求加入监听器
            channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
                if (channelFuture1.isSuccess()) {
                    CONNECT_DISPATCHER.add(dispatcherAddress);
                    SocketChannel socketChannel = (SocketChannel) channelFuture1.channel();
                    GATEWAY_CONNECT_DISPATCHER_MAP.put(dispatcherAddress,
                            socketChannel);
                    LOGGER.info("已经跟dispatcher系统建立连接,dispatcher系统接入系统地址为：" + dispatcherAddress);
                } else {
                    channelFuture1.channel().close();
                    threadGroup.shutdownGracefully();
                }
            });
        }
    }


    /**
     * 选择一台服务器
     * @param key 关键字（一般是ip地址+端口）
     */
    public String chooseServer(String key) {
        ChooseServerHandle chooseServerHandle = new RandomHandle();
        return chooseServerHandle.chooseServer(CONNECT_DISPATCHER, key);
    }


    /**
     * 返回一个channel
     * @param server dispatcher的服务器地址
     * @return 返回一个channel
     *
     */
    public SocketChannel getSocketChannel(String server) {
        return GATEWAY_CONNECT_DISPATCHER_MAP.get(server);
    }


    /**
     * 发送认证信息到分发系统
     * @param clientChannel 客户端的channel
     * @param authenticateRequest 认证请求
     */
    public void authenticate(SocketChannel clientChannel,AuthenticateRequest authenticateRequest) {
        // 选择一台服务器
        String server = this.chooseServer(ChannelIdUtils.getChannelId(clientChannel));
        MessageProtocolUtils.sendMsg(getSocketChannel(server),authenticateRequest);
    }
}
