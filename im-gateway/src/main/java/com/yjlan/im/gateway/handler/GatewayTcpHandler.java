package com.yjlan.im.gateway.handler;

import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.protocol.MessageHeader;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.SpringBeanFactory;
import com.yjlan.im.gateway.dispatcher.DispatcherManager;
import com.yjlan.im.gateway.session.SessionManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.gateway.server.GatewayNettyServer;

/**
 * @author yjlan
 * @version V1.0
 * @Description 负责处理TCP连接的handler
 * @date 2022.01.20 17:20
 */

public class GatewayTcpHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayTcpHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("已经跟客户端建立连接，客户端地址为：" + ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel socketChannel = (SocketChannel) ctx.channel();
        SessionManager.remove(socketChannel);
        LOGGER.info("检测到客户端的连接断开，删除其连接缓存：address:{}", socketChannel.remoteAddress().toString());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        LOGGER.info("tcp服务器收到的消息为:" + msg);
        // 首先需要认证一下是否已经登录拿到对应的token,进行认证
        MessageHeader header = msg.getHeader();
        // 如果是认证请求
        if (header.getMessageType() == MessageTypeManager.AUTHENTICATE_REQUEST.getMessageType()) {
            DispatcherManager dispatcherManager = SpringBeanFactory.getBean(DispatcherManager.class);
            // 这里如果认证通过的话，会在dispatcher中增加一个缓存
            AuthenticateRequest request = (AuthenticateRequest)msg.getBody();
            LOGGER.info(request.toString());
            dispatcherManager.authenticate((SocketChannel) ctx.channel(),request);
            SessionManager.put(request.getUid(),(SocketChannel) ctx.channel());
        }
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
        cause.printStackTrace();
        ctx.close();
    }
}
