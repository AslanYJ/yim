package com.yjlan.im.common.codec;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import com.yjlan.im.common.protocol.MessageProtocol;

/**
 * @author yjlan
 * @version V1.0
 * @Description 编码器
 * @date 2022.01.21 15:51
 */
@ChannelHandler.Sharable
public class MessageProtocolEncoder extends MessageToMessageEncoder<MessageProtocol> {
    
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol messageProtocol, List<Object> out)
            throws Exception {
        ByteBuf byteBuf = ctx.alloc().buffer();
        messageProtocol.enCode(byteBuf);
        out.add(byteBuf);
    }
}
