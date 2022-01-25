package com.yjlan.im.gateway.processor;

import javax.annotation.Resource;

import com.yjlan.im.common.proto.MessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.gateway.dispatcher.DispatcherManager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

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

    @Resource
    private DispatcherManager dispatcherManager;
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        MessagePushResponse messagePushResponse = (MessagePushResponse) message.getBody();
        LOGGER.info("收到推送消息的响应体,msg:{}",messagePushResponse.toString());
        dispatcherManager.forwardToDispatcher((SocketChannel) ctx.channel(),messagePushResponse);
    }

    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_PUSH_RESPONSE.getMessageType();
    }
}
