package com.yjlan.im.gateway.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author yjlan
 * @version V1.0
 * @Description 负责处理TCP连接的handler
 * @date 2022.01.20 17:20
 */
@ChannelHandler.Sharable
public class GatewayTcpHandler extends ChannelInboundHandlerAdapter {
    
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        channelHandlerContext.writeAndFlush(o);
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
