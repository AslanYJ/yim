package com.yjlan.im.business.offlinemessage.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.common.RocketMqProducer;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.entity.StoreMessage;
import com.yjlan.im.common.mq.RocketMqConstant;

/**
 * @author yjlan
 * @version V1.0
 * @Description topic: push_group_message_response的消费者
 * @date 2022.01.29 14:01
 */
@RocketMQMessageListener(
        topic = RocketMqConstant.PUSH_GROUP_MESSAGE_RESPONSE,
        consumerGroup = RocketMqConstant.PUSH_GROUP_MESSAGE_RESPONSE_GROUP,
        selectorExpression = "*"
)
@Component
public class PushGroupMessageResponseConsumer implements RocketMQListener<MessageExt> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PushGroupMessageResponseConsumer.class);
    
    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    
    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSON.parseObject(new java.lang.String(messageExt.getBody()));
        LOGGER.info("消费 push_group_message_response,msg:{}", jsonObject.toJSONString());
        Long receiverId = jsonObject.getLong("receiverId");
        Long groupId = jsonObject.getLong("groupId");
        Long timeStamp = jsonObject.getLong("timeStamp");
        String sendContent = jsonObject.getString("sendContent");
        StoreMessage storeMessage = new StoreMessage();
        storeMessage.setSendContent(sendContent);
        storeMessage.setTimeStamp(timeStamp);
        String key = RedisPrefixConstant.IM_MESSAGE + receiverId
                + "-" + groupId;
        // 如果已经读了，那么就删除对应的Redis中的聊天记录，否则就是离线消息
        Long removeResult = redisTemplate.opsForZSet().remove(key,JSONObject.toJSONString(storeMessage));
        if (removeResult == null || removeResult == 0) {
            LOGGER.info("groupId:{},receiverId:{},storeMessage:{}，删除失败",
                    groupId,receiverId,JSONObject.toJSONString(storeMessage));
        } else {
            // 发送 MQ 到send_group_message_response
            LOGGER.info("receiverId:{} 已经收到对应的消息，删除对应的离线消息",receiverId);
            rocketMqProducer.sendMsg(RocketMqConstant.SEND_GROUP_MESSAGE_RESPONSE, jsonObject.toJSONString());
        }
    }
}
