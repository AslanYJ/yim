package com.yjlan.im.gateway.handler;


import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yjlan.im.common.protocol.MessageHeader;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.utils.SpringBeanFactory;
import com.yjlan.im.gateway.processor.MessageProcessorFactory;


/**
 * @author yjlan
 * @version V1.0
 * @Description 负责处理分发系统的handler
 * @date 2022.01.20 17:20
 */
@Sharable
public class GatewayDelivererHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayDelivererHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("已经跟deliverer建立连接，客户端地址为：+ ctx.channel()");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageProtocol messageProtocol) throws Exception {
        final MessageHeader header = messageProtocol.getHeader();
        MessageProcessorFactory messageProcessorFactory = SpringBeanFactory.getBean(MessageProcessorFactory.class);
        messageProcessorFactory.getMessageProcessor(header.getMessageType())
                .process(messageProtocol,ctx);
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
