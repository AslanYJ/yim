package com.yjlan.im.business.offlinemessage.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.c2c.dao.PeerToPeerMessageDao;
import com.yjlan.im.business.c2c.entity.PeerToPeerMsg;
import com.yjlan.im.business.common.RocketMqProducer;
import com.yjlan.im.business.common.SaveMessageUtils;
import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.entity.StoreMessage;
import com.yjlan.im.common.mq.RocketMqConstant;

/**
 * @author yjlan
 * @version V1.0
 * @Description push_message_response 的消费者
 * @date 2022.01.25 09:07
 */
@RocketMQMessageListener(
        // topic
        topic = RocketMqConstant.PUSH_MESSAGE_RESPONSE,
        // 消费组
        consumerGroup = RocketMqConstant.PUSH_MESSAGE_RESPONSE_GROUP,
        // tag
        selectorExpression = "*"
)
@Component
public class PushMessageResponseConsumer implements RocketMQListener<MessageExt> {
    
    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Resource
    private SaveMessageUtils saveMessageUtils;
    
    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSON.parseObject(new String(messageExt.getBody()));
        // 发消息告诉客户端消息已经送达，并且已读
        JSONObject sendInfo = new JSONObject();
        Integer code = jsonObject.getInteger("code");
        String message = jsonObject.getString("message");
        Long senderId = jsonObject.getLong("senderId");
        Long receiverId = jsonObject.getLong("receiverId");
        Long timeStamp = jsonObject.getLong("timeStamp");
        String sendContent = jsonObject.getString("sendContent");
        sendInfo.put("code",code);
        sendInfo.put("message",message);
        sendInfo.put("senderId",senderId);
        sendInfo.put("receiverId",receiverId);
        sendInfo.put("timeStamp",timeStamp);
        StoreMessage storeMessage = new StoreMessage();
        storeMessage.setSendContent(sendContent);
        storeMessage.setTimeStamp(timeStamp);
        saveMessageUtils.removeMessage(receiverId,storeMessage);
        rocketMqProducer.sendMsg(RocketMqConstant.SEND_MESSAGE_RESPONSE, sendInfo.toJSONString());
    }
}
