package com.yjlan.im.dispatcher.service.processor;

import javax.annotation.Resource;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.MessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.dispatcher.service.mq.RocketMqProducer;

/**
 * @author yjlan
 * @version V1.0
 * @Description 消息推送响应处理器
 * @date 2022.01.25 09:02
 */
@Component
public class MessagePushResponseProcessor implements DispatcherMessageProcessor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessagePushResponseProcessor.class);
    
    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("dispatcher 收到的消息,message:{}",message.toString());
        // 直接转发到rocketMQ
        MessagePushResponse response = (MessagePushResponse)message.getBody();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageId",response.getMessageId());
        jsonObject.put("code",response.getCode());
        jsonObject.put("message",response.getMessage());
        rocketMqProducer.sendMsg(RocketMqConstant.PUSH_MESSAGE_RESPONSE, jsonObject.toJSONString());
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_PUSH_RESPONSE.getMessageType();
    }
}
