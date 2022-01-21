package com.yjlan.im.common.utils;

import com.google.protobuf.MessageLite;
import com.yjlan.im.common.constants.Constant;
import com.yjlan.im.common.protocol.MessageHeader;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 发送请求的工具类
 * @author yjlan
 */
public class MessageProtocolUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageProtocolUtils.class);
    /**
     * 发送消息
     * @param socketChannel 管道
     * @param messageLite 请求体
     */
    public static void sendMsg(SocketChannel socketChannel, MessageLite messageLite) {
        MessageHeader header = new MessageHeader();
        header.setHeaderLength(Constant.DEFAULT_MESSAGE_HEADER_LENGTH);
        header.setMessageType(MessageTypeManager.getMessageTypeTypeByBodyType(messageLite));
        header.setSequence(Constant.DEFAULT_SEQUENCE);
        header.setVersion(Constant.VERSION);
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setHeader(header);
        messageProtocol.setBody(messageLite);
        send(socketChannel,messageProtocol);
    }

    private static void send(Channel channel, MessageProtocol messageProtocol) {
        if (channel != null && channel.isActive() && channel.isWritable()) {
            ChannelFuture channelFuture = channel.writeAndFlush(messageProtocol);
            // 添加监听器，发送失败时打印日志
            channelFuture.addListener(future -> {
                if (!future.isSuccess()) {
                    LOGGER.error("send message error", future.cause());
                }
            });
        } else {
            assert channel != null;
            LOGGER.error("channel unavailable, channelId={}, msgType={}", channel.id(), ((MessageLite) messageProtocol.getBody()).getClass());
        }
    }
}
