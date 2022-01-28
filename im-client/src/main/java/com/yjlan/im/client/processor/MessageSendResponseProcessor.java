package com.yjlan.im.client.processor;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.MessageSendResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description 请求响应处理
 * @date 2022.01.28 11:21
 */

@Component
public class MessageSendResponseProcessor implements ClientMessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSendResponseProcessor.class);
    
    @Override
    public void process(MessageProtocol messageProtocol, ChannelHandlerContext ctx) {
        MessageSendResponse messageSendResponse = (MessageSendResponse) messageProtocol.getBody();
        LOGGER.info("get send message response,msg:{}",messageSendResponse.toString());
    }
    
    @Override
    public int getMessageType() {
        return MessageTypeManager.MESSAGE_SEND_RESPONSE.getMessageType();
    }
}
