package com.yjlan.im.client.client;

import com.yjlan.im.client.config.ClientConfig;
import com.yjlan.im.client.handler.ImClientHandler;
import com.yjlan.im.common.codec.MessageProtocolDecoder;
import com.yjlan.im.common.codec.MessageProtocolEncoder;

import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.exception.ImException;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.proto.GroupMessageSendRequest;
import com.yjlan.im.common.proto.MessageSendRequest;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author yjlan
 * @version V1.0
 * @Description client的启动器
 * @date 2022.01.20 15:36
 */
@Component
public class ImNettyClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImNettyClient.class);

    @Resource
    private ClientConfig clientConfig;

    /**
     * 和客户端连接的工作线程
     */
    private final EventLoopGroup threadGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("im-client-work"));

    /**
     * 和服务器连接的channel
     */
    private SocketChannel socketChannel;
    
    private Boolean isAuthenticate = true;


    @PostConstruct
    public void init() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(threadGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        // 一次解码器
                        pipeline.addLast(new ProtobufVarint32FrameDecoder());
                        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                        // 二次解码器
                        pipeline.addLast(new MessageProtocolDecoder());
                        pipeline.addLast(new MessageProtocolEncoder());
                        pipeline.addLast(new ImClientHandler());
                    }
                });
        // 尝试发起连接
        ChannelFuture channelFuture = bootstrap.connect(clientConfig.getIp(), clientConfig.getPort());
        // 给异步化的连接请求加入监听器
        channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
            if (channelFuture1.isSuccess()) {
                socketChannel = (SocketChannel) channelFuture1.channel();
                LOGGER.info("已经跟TCP接入系统建立连接，TCP接入系统地址为：" + socketChannel);
            } else {
                channelFuture1.channel().close();
                threadGroup.shutdownGracefully();
            }
        });
    }
    
    
    /**
     * 认证请求
     * @param token 对应的token
     */
    public void authenticate(String token) {
        AuthenticateRequest request = AuthenticateRequest.newBuilder()
                .setToken(token)
                .setUid(clientConfig.getUserId())
                .setTimestamp(System.currentTimeMillis())
                .setInstanceCode("").build();
        MessageProtocolUtils.sendMsg(socketChannel,request);
    }
    
    
    /**
     * 单聊
     * @param receiverId 接收人
     * @param sendContent 内容
     */
    public void sendMessagePeer2Peer(Long receiverId,String sendContent) {
        if (!isAuthenticate) {
            throw new ImException(ImBusinessCode.AUTHENTICATE_FAIL,"用户没有认证");
        }
        
        MessageSendRequest request = MessageSendRequest.newBuilder()
                .setSenderId(clientConfig.getUserId())
                .setReceiverId(receiverId)
                .setSendContent(sendContent)
                .build();
        MessageProtocolUtils.sendMsg(socketChannel,request);
    }
    
    
    /**
     * 发送群消息
     * @param groupId 群组id
     * @param sendContent 内容
     */
    public void sendGroupMessage(Long groupId,String sendContent) {
        GroupMessageSendRequest request = GroupMessageSendRequest.newBuilder()
                .setSenderId(clientConfig.getUserId())
                .setGroupId(groupId)
                .setSendContent(sendContent)
                .setTimeStamp(System.currentTimeMillis())
                .build();
        MessageProtocolUtils.sendMsg(socketChannel,request);
    }

    /**
     * 关闭连接
     */
    @PreDestroy
    public void close() {
        if (socketChannel != null) {
            socketChannel.close();
        }
        threadGroup.shutdownGracefully();
    }
}
