package com.yjlan.im.message.push.handler;

import com.yjlan.im.common.protocol.MessageHeader;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.utils.ChannelIdUtils;
import com.yjlan.im.common.utils.SpringBeanFactory;

import com.yjlan.im.message.push.session.GatewaySessionManager;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yjlan
 * @version V1.0
 * @Description 负责推送系统的handler
 * @date 2022.01.20 17:20
 */
@Sharable
public class MessagePushHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePushHandler.class);

    
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("推送服务已经跟gateway建立连接，gateway地址为,msg：{}", ctx.channel().remoteAddress().toString());
        GatewaySessionManager.put((SocketChannel) ctx.channel());
        LOGGER.info("channelId:{}", ChannelIdUtils.getChannelId((SocketChannel)ctx.channel()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("推送服务已经跟gateway断开连接，gateway地址为,msg:{}", ctx.channel().remoteAddress().toString());
        GatewaySessionManager.remove((SocketChannel) ctx.channel());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        LOGGER.info("推送服务器收到的消息为:" + msg.getBody().toString());

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
