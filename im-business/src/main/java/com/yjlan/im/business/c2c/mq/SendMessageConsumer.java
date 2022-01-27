package com.yjlan.im.business.c2c.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.c2c.dao.PeerToPeerMessageDao;
import com.yjlan.im.business.c2c.entity.PeerToPeerMsg;
import com.yjlan.im.business.common.RocketMqProducer;
import com.yjlan.im.common.mq.RocketMqConstant;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yjlan
 * @version V1.0
 * @Description send_message topic的消费者
 * @date 2022.01.24 15:25
 */
@RocketMQMessageListener(
        // topic
        topic = RocketMqConstant.SEND_MESSAGE,
        // 消费组
        consumerGroup = RocketMqConstant.SEND_MESSAGE_GROUP,
        // tag
        selectorExpression = "*"
)
@Component
public class SendMessageConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageConsumer.class);

    @Resource
    private PeerToPeerMessageDao peerToPeerMessageDao;

    @Resource
    private RocketMqProducer rocketMqProducer;

    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSONObject.parseObject(new String(messageExt.getBody()));
        LOGGER.info("get send message,message:{}",jsonObject.toJSONString());
        // 并发高 不适合用Msql直接做存储
        PeerToPeerMsg peerToPeerMsg = new PeerToPeerMsg();
        peerToPeerMsg.setSendContent(jsonObject.getString("sendContent"));
        peerToPeerMsg.setSenderId(jsonObject.getLong("senderId"));
        peerToPeerMsg.setReceiverId(jsonObject.getLong("receiverId"));
        peerToPeerMessageDao.insert(peerToPeerMsg);
        sendPushMessage(peerToPeerMsg);
    }

    /**
     * 发送push消息到
     *
     * @param peerToPeerMsg 需要push的消息
     */
    private void sendPushMessage(PeerToPeerMsg peerToPeerMsg) {
        rocketMqProducer.sendMsg(RocketMqConstant.PUSH_MESSAGE, JSON.toJSONString(peerToPeerMsg));
    }
}
