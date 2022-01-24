package com.yjlan.im.dispatcher.handler;

import com.google.protobuf.MessageLite;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.protocol.MessageHeader;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.ChannelIdUtils;
import com.yjlan.im.common.utils.SpringBeanFactory;
import com.yjlan.im.dispatcher.service.processor.DispatcherMessageProcessorFactory;
import com.yjlan.im.dispatcher.service.sso.SsoService;
import com.yjlan.im.dispatcher.session.GatewaySessionManager;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.yjlan.im.common.protocol.MessageProtocol;


/**
 * @author yjlan
 * @version V1.0
 * @Description 负责处理分发系统的handler
 * @date 2022.01.20 17:20
 */
@Sharable
public class DispatcherHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherHandler.class);

    
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("已经跟gateway建立连接，gateway地址为,msg：{}", ctx.channel().remoteAddress().toString());
        GatewaySessionManager.put((SocketChannel) ctx.channel());
        LOGGER.info("channelId:{}", ChannelIdUtils.getChannelId((SocketChannel)ctx.channel()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("已经跟gateway断开连接，gateway地址为,msg:{}", ctx.channel().remoteAddress().toString());
        GatewaySessionManager.remove((SocketChannel) ctx.channel());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        LOGGER.info("分发服务器收到的消息为:" + msg.getBody().toString());
        MessageHeader header = msg.getHeader();
        MessageLite body = msg.getBody();
        // 认证请求，那么就访问sso系统认证
        if (header.getMessageType() == MessageTypeManager.AUTHENTICATE_REQUEST.getMessageType()) {
            SsoService ssoService = SpringBeanFactory.getBean(SsoService.class);
            boolean authenticate = ssoService.authenticate((AuthenticateRequest) body);
            if (authenticate) {
                // 存入redis中
            }
        }
        
        DispatcherMessageProcessorFactory messageProcessorFactory = SpringBeanFactory
                .getBean(DispatcherMessageProcessorFactory.class);
        messageProcessorFactory.getMessageProcessor(header.getMessageType())
                .process(msg,ctx);
    }


    /**
     * 处理完毕一个请求
     *
     * @param ctx channel上下文
     * @throws Exception 异常
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }


    /**
     * 发生异常
     *
     * @param ctx   channel上下文
     * @param cause 异常
     * @throws Exception 抛出异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.info(cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
