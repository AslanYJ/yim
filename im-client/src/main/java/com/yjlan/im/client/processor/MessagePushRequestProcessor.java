package com.yjlan.im.client.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.proto.MessagePushRequest;
import com.yjlan.im.common.proto.MessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;

/**
 * @author yjlan
 * @version V1.0
 * @Description 推送消息请求的处理器
 * @date 2022.01.28 11:19
 */
@Component
public class MessagePushRequestProcessor implements ClientMessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePushRequestProcessor.class);
    
    @Override
    public void process(MessageProtocol messageProtocol, ChannelHandlerContext ctx) {
        MessagePushRequest messagePushRequest = (MessagePushRequest) messageProtocol.getBody();
        LOGGER.info("receive message messageId:{},senderId:{},receiverId:{},sendContent:{}",
                messagePushRequest.getMessageId(),
                messagePushRequest.getSenderId(),
                messagePushRequest.getReceiverId(),
                messagePushRequest.getSendContent());
        // 直接返回一个Response
        MessagePushResponse messagePushResponse = MessagePushResponse.newBuilder()
                .setCode(ImBusinessCode.MESSAGE_READ_SUCCESS)
                .setMessage("消息读取成功！")
                .setSendContent(messagePushRequest.getSendContent())
                .setReceiverId(messagePushRequest.getReceiverId())
                .setSenderId(messagePushRequest.getSenderId())
                .setTimestamp(messagePushRequest.getTimestamp())
                .build();
        MessageProtocolUtils.sendMsg((SocketChannel) ctx.channel(),messagePushResponse);
    }
    
    @Override
    public int getMessageType() {
        return MessageTypeManager.MESSAGE_PUSH_REQUEST.getMessageType();
    }
}
