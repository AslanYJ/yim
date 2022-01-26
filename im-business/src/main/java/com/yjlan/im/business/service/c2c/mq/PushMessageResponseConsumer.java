package com.yjlan.im.business.service.c2c.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.dao.PeerToPeerMessageDao;
import com.yjlan.im.business.entity.PeerToPeerMsg;
import com.yjlan.im.common.constants.ImBusinessCode;
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
    private PeerToPeerMessageDao peerToPeerMessageDao;
    
    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSON.parseObject(new String(messageExt.getBody()));
        // 修改消息状态
        Long messageId = jsonObject.getLong("messageId");
        peerToPeerMessageDao.updateByMessageId(messageId);
        // 发消息告诉客户端消息已经送达，并且已读
        PeerToPeerMsg peerToPeerMsg = peerToPeerMessageDao.getById(messageId);
        JSONObject sendInfo = new JSONObject();
        sendInfo.put("code",ImBusinessCode.MESSAGE_READ_SUCCESS);
        sendInfo.put("message",messageId + "-" + "消息已经读取");
        sendInfo.put("senderId",peerToPeerMsg.getSenderId());
        sendInfo.put("receiverId",peerToPeerMsg.getReceiverId());
        sendInfo.put("timeStamp",System.currentTimeMillis());
        rocketMqProducer.sendMsg(RocketMqConstant.SEND_MESSAGE_RESPONSE, sendInfo.toJSONString());
    }
}
