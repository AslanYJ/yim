package com.yjlan.im.deliverer.mq;

import javax.annotation.Resource;

import io.netty.channel.socket.SocketChannel;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.GroupMessagePushRequest;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.deliverer.session.GatewaySessionManager;

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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupPushMessageConsumer.class);
    
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    
    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSON.parseObject(new String(messageExt.getBody()));
        // 这里需要看一下有没有对应的session信息，没有的话，那么就直接生成离线消息。
        Long receiverId = jsonObject.getLong("receiverId");
        Long groupId = jsonObject.getLong("groupId");
        String sendContent = jsonObject.getString("sendContent");
        Long timeStamp = jsonObject.getLong("timeStamp");
        Long senderId = jsonObject.getLong("senderId");
        String instanceCode = (String) redisTemplate.opsForHash().get(RedisPrefixConstant.USER_SESSION + receiverId,
                "instanceCode");
        // 能查到证明是有session的，因此可以直接发送
        if (StringUtils.isNotBlank(instanceCode)) {
            SocketChannel gatewaySocketChannel = GatewaySessionManager.getGatewayChannel(instanceCode);
            GroupMessagePushRequest request = GroupMessagePushRequest.newBuilder()
                    .setGroupId(groupId)
                    .setSendContent(sendContent)
                    .setReviverId(receiverId)
                    .setTimeStamp(timeStamp)
                    .setSenderId(senderId)
                    .build();
            if (gatewaySocketChannel == null || !gatewaySocketChannel.isActive()) {
                LOGGER.error("instanceCode:{} 服务器异常",instanceCode);
                return;
            }
            MessageProtocolUtils.sendMsg(gatewaySocketChannel,request);
        }
    }
}
