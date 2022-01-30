package com.yjlan.im.client.processor;

import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GroupMessageSendResponse的处理器
 * @author yjlan
 */
@Component
public class GroupMessageSendResponseProcessor implements ClientMessageProcessor{

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessageSendResponseProcessor.class);

    @Override
    public void process(MessageProtocol messageProtocol, ChannelHandlerContext ctx) {
        LOGGER.info("收到group message send response的消息");
    }

    @Override
    public int getMessageType() {
        return MessageTypeManager.GROUP_MESSAGE_SEND_RESPONSE.getMessageType();
    }
}
