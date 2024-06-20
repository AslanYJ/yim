package com.yjlan.im.gateway.processor;

import javax.annotation.Resource;

import com.yjlan.im.gateway.deliverer.DelivererManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.GroupMessagePushResponse;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群消息推送返回
 * @date 2022.01.29 13:52
 */
@Component
public class GroupMessagePushResponseProcessor implements MessageProcessor{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessagePushResponseProcessor.class);
    
    @Resource
    private DelivererManager delivererManager;
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        LOGGER.info("gateway 收到group message push 的响应,投递到deliverer");
        GroupMessagePushResponse response = (GroupMessagePushResponse) message.getBody();
        delivererManager.forwardToDeliverer((SocketChannel) ctx.channel(),response);
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.GROUP_MESSAGE_PUSH_RESPONSE.getMessageType();
    }
}
