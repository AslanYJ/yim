package com.yjlan.im.deliverer.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.mq.RocketMqConstant;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群消息推送消费
 * @date 2022.01.28 15:12
 */
@RocketMQMessageListener(
        topic = RocketMqConstant.PUSH_GROUP_MESSAGE,
        consumerGroup = RocketMqConstant.PUSH_GROUP_MESSAGE_GROUP
)
@Component
public class GroupPushMessageConsumer implements RocketMQListener<MessageExt> {
    
    
    @Override
    public void onMessage(MessageExt messageExt) {
    
    }
}
