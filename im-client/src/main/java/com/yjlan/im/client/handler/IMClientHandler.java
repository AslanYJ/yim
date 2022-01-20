package com.yjlan.im.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author yjlan
 * @version V1.0
 * @Description client的处理handler
 * @date 2022.01.20 15:36
 *
 * */

public class IMClientHandler extends ChannelInboundHandlerAdapter {

    private final static Logger LOGGER = LoggerFactory.getLogger(IMClientHandler.class);


    /**
     * 收到服务器的响应
     * @param ctx 对应的channel
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] msgBuffer = new byte[byteBuf.readableBytes()];
        // 将消息读到msgBuffer中
        byteBuf.readBytes(msgBuffer);
        String content = new String(msgBuffer, StandardCharsets.UTF_8);
        LOGGER.info("从TCP服务器收到的消息为:" + content);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端和服务端建立连接时调用
        LOGGER.info("client和gateway 连接成功!");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("client 和服务器断开连接");
    }

}
