package com.yjlan.im.gateway.processor;

import com.yjlan.im.common.proto.GroupMessageSendResponse;
import com.yjlan.im.common.proto.MessageSendResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.gateway.session.SessionManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GroupMessageSendResponseProcessor
 * @author yjlan
 */
@Component
public class GroupMessageSendResponseProcessor implements MessageProcessor{


    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessageSendResponseProcessor.class);


    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("gateway 收到 group message send response , msg:{}",message.toString());
        GroupMessageSendResponse messageSendResponse = (GroupMessageSendResponse) message.getBody();
        // 拿到senderId的channel
        Long senderId = messageSendResponse.getSenderId();
        final SocketChannel socketChannel = SessionManager.getSocketChannel(senderId);
        MessageProtocolUtils.sendMsg(socketChannel,messageSendResponse);
    }

    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.GROUP_MESSAGE_SEND_RESPONSE.getMessageType();
    }
}
