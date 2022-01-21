package com.yjlan.im.common.codec;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import com.yjlan.im.common.protocol.MessageProtocol;

/**
 * @author yjlan
 * @version V1.0
 * @Description Message的解码器
 * @date 2022.01.21 15:51
 */
@ChannelHandler.Sharable
public class MessageProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.deCode(msg);
        out.add(messageProtocol);
    }
}
