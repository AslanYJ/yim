package com.yjlan.im.gateway.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.GroupMessageSendRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群消息请求发送
 * @date 2022.01.28 11:39
 */
@Component
public class GroupMessageSendRequestProcessor implements MessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessageSendRequest.class);
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        GroupMessageSendRequest request = (GroupMessageSendRequest) message.getBody();
        LOGGER.info("收到群消息请求,msg:{}",request.toString());
        MessageProtocolUtils.sendMsg((SocketChannel) ctx.channel(),request);
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.GROUP_MESSAGE_SEND_REQUEST.getMessageType();
    }
}
