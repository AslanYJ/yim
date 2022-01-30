package com.yjlan.im.dispatcher.mq;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.GroupMessageSendResponse;
import com.yjlan.im.common.utils.MessageProtocolUtils;
import com.yjlan.im.dispatcher.session.GatewaySessionManager;
import io.netty.channel.socket.SocketChannel;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@RocketMQMessageListener(
        topic = RocketMqConstant.SEND_GROUP_MESSAGE_RESPONSE,
        consumerGroup = RocketMqConstant.SEND_GROUP_MESSAGE_RESPONSE_GROUP,
        selectorExpression = "*"
)
@Component
public class SendGroupMessageResponseConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendGroupMessageResponseConsumer.class);

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void onMessage(MessageExt messageExt) {
        LOGGER.info("dispatcher 消费topic:{}",RocketMqConstant.SEND_GROUP_MESSAGE_RESPONSE);
        JSONObject jsonObject = JSON.parseObject(new String(messageExt.getBody()));
        long senderId = jsonObject.getLong("senderId");
        // 发消息告诉客户端消息已经送达，并且已读
        String instanceCode = (String)redisTemplate.opsForHash()
                .get(RedisPrefixConstant.USER_SESSION + senderId,
                        "instanceCode");
        SocketChannel socketChannel = GatewaySessionManager.getHasAuthSocketChannel(instanceCode);
        if (socketChannel != null) {
            GroupMessageSendResponse response = GroupMessageSendResponse.newBuilder()
                    .setCode(ImBusinessCode.MESSAGE_READ_SUCCESS)
                    .setMessage("群消息已读")
                    .setGroupId(jsonObject.getLongValue("groupId"))
                    .setSenderId(jsonObject.getLongValue("senderId"))
                    .setTimestamp(jsonObject.getLongValue("timeStamp"))
                    .setReceiverId(jsonObject.getLongValue("receiverId"))
                    .setSendContent(jsonObject.getString("sendContent"))
                    .build();
            MessageProtocolUtils.sendMsg(socketChannel,response);
        }
    }
}
