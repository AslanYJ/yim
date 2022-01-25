package com.yjlan.im.dispatcher.service.mq;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.MessagePushRequest;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.dispatcher.constants.RedisPrefixConstant;
import com.yjlan.im.dispatcher.session.GatewaySessionManager;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yjlan
 * @version V1.0
 * @Description push_message topic的消费者
 * @date 2022.01.24 15:25
 */
@RocketMQMessageListener(
        topic = RocketMqConstant.PUSH_MESSAGE,
        consumerGroup = RocketMqConstant.PUSH_MESSAGE_GROUP
)
@Component
public class PushMessageConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PushMessageConsumer.class);

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSONObject.parseObject(new String(messageExt.getBody()));
        LOGGER.info("get push message,message:{}", jsonObject.toJSONString());
        // 从Redis中拿到对应的receiverId的gatewayChannelId
        String receiverId = jsonObject.getString("receiverId");
        String gatewayChannelId = (String) redisTemplate.opsForHash().get(RedisPrefixConstant.USER_SESSION + receiverId,
                "gatewayChannelId");
        if (StringUtils.isNotBlank(gatewayChannelId)) {
            SocketChannel gatewaySocketChannel = GatewaySessionManager.getGatewayChannel(gatewayChannelId);
            MessagePushRequest messagePushRequest = MessagePushRequest.newBuilder()
                    .setMessageId(jsonObject.getLongValue("id"))
                    .setSenderId(jsonObject.getString("senderId"))
                    .setReceiverId(receiverId)
                    .setSendContent(jsonObject.getString("sendContent"))
                    .setTimestamp(System.currentTimeMillis())
                    .build();
            if (gatewaySocketChannel == null) {
                LOGGER.error("gatewayChannelId is null id:{}",gatewayChannelId);
                return;
            }
            MessageProtocolUtils.sendMsg(gatewaySocketChannel,messagePushRequest);
        } else {
            LOGGER.error("gatewayChannelId is null");
        }
    }
}
