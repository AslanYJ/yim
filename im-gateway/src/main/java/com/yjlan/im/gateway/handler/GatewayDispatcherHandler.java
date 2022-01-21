package com.yjlan.im.gateway.handler;

import com.yjlan.im.common.protocol.MessageProtocol;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yjlan
 * @version V1.0
 * @Description 负责处理分发系统的handler
 * @date 2022.01.20 17:20
 */
@Sharable
public class GatewayDispatcherHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayDispatcherHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("已经跟客户端建立连接，客户端地址为：" + ctx.channel());
    }

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {
        LOGGER.info("分发服务器收到的消息为:" + messageProtocol);
     
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
