package com.yjlan.im.gateway.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.GroupMessagePushRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.gateway.session.SessionManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群消息推送
 * @date 2022.01.29 09:37
 */
@Component
public class GroupMessagePushRequestProcessor implements MessageProcessor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessagePushRequestProcessor.class);
    
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        GroupMessagePushRequest request = (GroupMessagePushRequest) message.getBody();
        Long receiverId = request.getReviverId();
        LOGGER.info("gateway 收到群消息推送,receiverId:{}",receiverId);
        final SocketChannel socketChannel = SessionManager.getSocketChannel(receiverId);
        // 不发送，默认为是离线消息
        if (socketChannel == null || !socketChannel.isActive() || socketChannel.isShutdown()) {
            return;
        }
        MessageProtocolUtils.sendMsg(socketChannel,request);
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.GROUP_MESSAGE_PUSH_REQUEST.getMessageType();
    }
}
