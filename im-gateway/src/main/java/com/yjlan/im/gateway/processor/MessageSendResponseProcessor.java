package com.yjlan.im.gateway.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.MessageSendResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.gateway.session.SessionManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description message send response请求的processor
 * @date 2022.01.25 09:38
 */
@Component
public class MessageSendResponseProcessor implements MessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSendResponseProcessor.class);
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("gateway 收到 message send response , msg:{}",message.toString());
        MessageSendResponse messageSendResponse = (MessageSendResponse) message.getBody();
        // 拿到senderId的channel
        Long senderId = messageSendResponse.getSenderId();
        final SocketChannel socketChannel = SessionManager.getSocketChannel(senderId);
        MessageProtocolUtils.sendMsg(socketChannel,messageSendResponse);
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_SEND_RESPONSE.getMessageType();
    }
}
