package com.yjlan.im.dispatcher.processor;

import javax.annotation.Resource;

import io.netty.channel.ChannelHandlerContext;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.common.proto.MessageSendRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.dispatcher.mq.RocketMqProducer;

/**
 * @author yjlan
 * @version V1.0
 * @Description 发送消息转发器
 * @date 2022.01.24 14:33
 */
@Component
public class MessageSendRequestProcessor implements DispatcherMessageProcessor{
    
    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        MessageSendRequest sendRequest = (MessageSendRequest) message.getBody();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("senderId",sendRequest.getSenderId());
        jsonObject.put("receiverId",sendRequest.getReceiverId());
        jsonObject.put("sendContent",sendRequest.getSendContent());
        rocketMqProducer.sendMsg(RocketMqConstant.SEND_MESSAGE,jsonObject.toJSONString());
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_SEND_REQUEST.getMessageType();
    }
}
