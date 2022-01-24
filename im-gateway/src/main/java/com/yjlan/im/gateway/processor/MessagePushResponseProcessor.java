package com.yjlan.im.gateway.processor;

import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 处理推送消息的响应
 * @author yjlan
 */
@Component
public class MessagePushResponseProcessor implements MessageProcessor{

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePushResponseProcessor.class);

    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("收到推送消息的响应体,msg:{}",message.toString());
    }

    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_PUSH_RESPONSE.getMessageType();
    }
}
