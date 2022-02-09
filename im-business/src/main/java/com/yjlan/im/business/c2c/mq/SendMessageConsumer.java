package com.yjlan.im.business.c2c.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.c2c.dao.PeerToPeerMessageDao;
import com.yjlan.im.business.c2c.entity.PeerToPeerMsg;
import com.yjlan.im.business.common.RocketMqProducer;
import com.yjlan.im.business.common.SaveMessageUtils;
import com.yjlan.im.common.entity.StoreMessage;
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
    private RocketMqProducer rocketMqProducer;
    
    @Resource
    private SaveMessageUtils saveMessageUtils;

    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSONObject.parseObject(new String(messageExt.getBody()));
        LOGGER.info("get send message,message:{}",jsonObject.toJSONString());
        // 并发高 不适合用Msql直接做存储
        String sendContent = jsonObject.getString("sendContent");
        Long receiverId = jsonObject.getLong("receiverId");
        Long senderId = jsonObject.getLong("senderId");
        // 消息存储到Redis中,收到response后直接删除。没有删除的就是离线消息。
        StoreMessage storeMessage = new StoreMessage();
        storeMessage.setTimeStamp(System.currentTimeMillis());
        storeMessage.setSendContent(sendContent);
        saveMessageUtils.saveMessageToRedis(receiverId,storeMessage);
        sendPushMessage(sendContent,senderId,receiverId,storeMessage.getTimeStamp());
    }
    
    /**
     * 发送消息到MQ
     * @param sendContent 内容
     * @param senderId 发送者
     * @param receiverId 接受者
     */
    private void sendPushMessage(String sendContent,Long senderId,Long receiverId,Long timeStamp) {
        JSONObject peerToPeerMsg = new JSONObject();
        peerToPeerMsg.put("sendContent",sendContent);
        peerToPeerMsg.put("senderId",senderId);
        peerToPeerMsg.put("receiverId",receiverId);
        peerToPeerMsg.put("timeStamp",timeStamp);
        rocketMqProducer.sendMsg(RocketMqConstant.PUSH_MESSAGE,peerToPeerMsg.toJSONString());
    }
}
