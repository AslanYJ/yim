package com.yjlan.im.gateway.processor;

import com.yjlan.im.common.proto.MessagePushRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.gateway.session.SessionManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

/**
 * 收到push的请求
 * @author yjlan
 */
@Component
public class MessagePushRequestProcessor implements MessageProcessor{
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        MessagePushRequest messagePushRequest = (MessagePushRequest) message.getBody();
        // 找到对应的receiverId的socketChannel，发送消息
        Long receiverId = messagePushRequest.getReceiverId();
        SocketChannel socketChannel = SessionManager.getSocketChannel(receiverId);
        MessageProtocolUtils.sendMsg(socketChannel,messagePushRequest);
    }

    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_PUSH_REQUEST.getMessageType();
    }
}
