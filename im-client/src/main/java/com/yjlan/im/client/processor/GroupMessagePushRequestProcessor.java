package com.yjlan.im.client.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.proto.GroupMessagePushRequest;
import com.yjlan.im.common.proto.GroupMessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.common.utils.MessageProtocolUtils;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群推送消息处理
 * @date 2022.01.28 11:23
 */
@Component
public class GroupMessagePushRequestProcessor implements ClientMessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessagePushRequestProcessor.class);
    
    @Override
    public void process(MessageProtocol messageProtocol, ChannelHandlerContext ctx) {
        GroupMessagePushRequest request = (GroupMessagePushRequest) messageProtocol.getBody();
        long senderId = request.getSenderId();
        long groupId = request.getGroupId();
        String sendContent = request.getSendContent();
        Long timeStamp = request.getTimeStamp();
        long receiverId = request.getReviverId();
        LOGGER.info("收到群消息,senderId:{},receiverId:{},sendContent:{},groupId:{},timeStamp:{}",
                senderId,receiverId,sendContent,groupId,timeStamp);
        GroupMessagePushResponse response = GroupMessagePushResponse.newBuilder()
                .setCode(ImBusinessCode.PUSH_MESSAGE_READ_SUCCESS)
                .setMessage("群消息读取成功")
                .setSenderId(senderId)
                .setGroupId(groupId)
                .setReceiverId(receiverId)
                .setSendContent(request.getSendContent())
                .setTimeStamp(request.getTimeStamp())
                .build();
        MessageProtocolUtils.sendMsg((SocketChannel) ctx.channel(),response);
    }
    
    
    @Override
    public int getMessageType() {
        return MessageTypeManager.GROUP_MESSAGE_PUSH_REQUEST.getMessageType();
    }
}
