package com.yjlan.im.gateway.handler;

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
    public void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol msg) throws Exception {
        LOGGER.info("tcp服务器收到的消息为:" + msg);
        if (GatewayNettyServer.clientSocketChannel == null) {
            GatewayNettyServer.clientSocketChannel = (SocketChannel) channelHandlerContext.channel();
        }
    }
    
    
    /**
     * 处理完毕一个请求
     * @param ctx channel上下文
     * @throws Exception 异常
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    
    
    /**
     * 发生异常
     * @param ctx channel上下文
     * @param cause 异常
     * @throws Exception 抛出异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
