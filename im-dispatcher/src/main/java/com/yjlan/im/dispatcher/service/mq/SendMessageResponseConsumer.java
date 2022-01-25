package com.yjlan.im.dispatcher.service.mq;

import javax.annotation.Resource;

import io.netty.channel.socket.SocketChannel;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.MessageSendResponse;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.dispatcher.constants.RedisPrefixConstant;
import com.yjlan.im.dispatcher.session.GatewaySessionManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description send_message_response 的消费者
 * @date 2022.01.25 09:07
 */
@RocketMQMessageListener(
        // topic
        topic = RocketMqConstant.SEND_MESSAGE_RESPONSE,
        // 消费组
        consumerGroup = RocketMqConstant.SEND_MESSAGE_RESPONSE_GROUP,
        // tag
        selectorExpression = "*"
)
@Component
public class SendMessageResponseConsumer implements RocketMQListener<MessageExt> {
    
    
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    
    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSON.parseObject(new String(messageExt.getBody()));
        // 修改消息状态
        String senderId = jsonObject.getString("senderId");
        // 发消息告诉客户端消息已经送达，并且已读
        String gatewayChannelId = (String)redisTemplate.opsForHash()
                .get(RedisPrefixConstant.USER_SESSION + senderId,
                        "gatewayChannelId");
        MessageSendResponse response = MessageSendResponse.newBuilder()
                .setSenderId(jsonObject.getString("senderId"))
                .setReceiverId(jsonObject.getString("receiverId"))
                .setMessage(jsonObject.getString("message"))
                .setCode(jsonObject.getIntValue("code"))
                .setTimestamp(jsonObject.getLongValue("timeStamp"))
                .build();
        if (StringUtils.isNotBlank(gatewayChannelId)) {
            final SocketChannel gatewayChannel = GatewaySessionManager.getGatewayChannel(gatewayChannelId);
            MessageProtocolUtils.sendMsg(gatewayChannel,response);
        }
        
    }
}
