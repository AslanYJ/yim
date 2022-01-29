package com.yjlan.im.dispatcher.processor;

import javax.annotation.Resource;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.GroupMessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.dispatcher.mq.RocketMqProducer;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群消息推送返回响应
 * @date 2022.01.29 13:56
 */
@Component
public class GroupMessagePushResponseProcessor implements DispatcherMessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessagePushResponseProcessor.class);
    
    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("dispatcher 收到 gateway的 group message push response 消息");
        GroupMessagePushResponse response = (GroupMessagePushResponse) message.getBody();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("senderId",response.getSenderId());
        jsonObject.put("receiverId",response.getReceiverId());
        jsonObject.put("sendContent",response.getSendContent());
        jsonObject.put("timeStamp",response.getTimeStamp());
        jsonObject.put("groupId",response.getGroupId());
        rocketMqProducer.sendMsg(RocketMqConstant.PUSH_GROUP_MESSAGE_RESPONSE,jsonObject.toJSONString());
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.GROUP_MESSAGE_PUSH_RESPONSE.getMessageType();
    }
}
