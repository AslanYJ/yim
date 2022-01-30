package com.yjlan.im.deliverer.processor;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.GroupMessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.deliverer.mq.RocketMqProducer;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 群消息响应
 * @author yjlan
 */
@Component
public class GroupMessagePushResponseProcessor implements DelivererMessageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessagePushResponseProcessor.class);


    @Resource
    private RocketMqProducer rocketMqProducer;

    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("deliverer 收到group push message response");
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
