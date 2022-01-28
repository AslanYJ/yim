package com.yjlan.im.dispatcher.processor;

import javax.annotation.Resource;

import io.netty.channel.ChannelHandlerContext;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.GroupMessageSendRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.dispatcher.mq.RocketMqProducer;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群消息发送
 * @date 2022.01.28 11:37
 */
@Component
public class GroupMessageSendRequestProcessor implements DispatcherMessageProcessor{
    
    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        GroupMessageSendRequest request = (GroupMessageSendRequest) message.getBody();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("senderId",request.getSenderId());
        jsonObject.put("groupId",request.getGroupId());
        jsonObject.put("sendContent",request.getSendContent());
        jsonObject.put("timeStamp",request.getTimeStamp());
        rocketMqProducer.sendMsg(RocketMqConstant.SEND_GROUP_MESSAGE,jsonObject.toJSONString());
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.GROUP_MESSAGE_SEND_REQUEST.getMessageType();
    }
}
