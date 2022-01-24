package com.yjlan.im.business.service.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.dao.PeerToPeerMessageDao;
import com.yjlan.im.common.mq.RocketMqConstant;

/**
 * @author yjlan
 * @version V1.0
 * @Description send_message topic的消费者
 * @date 2022.01.24 15:25
 */
@RocketMQMessageListener(
        topic = RocketMqConstant.SEND_MESSAGE,// topic
        consumerGroup = RocketMqConstant.SEND_MESSAGE_GROUP,// 消费组
        selectorExpression = "*" // tag
)
@Component
public class SendMessageConsumer implements RocketMQListener<MessageExt> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageConsumer.class);
    
    @Resource
    private PeerToPeerMessageDao peerToPeerMessageDao;
    
    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject object = JSONObject.parseObject(new String(messageExt.getBody()));
        
        LOGGER.info("接收到消息==============" + object.toJSONString());
    }
}
