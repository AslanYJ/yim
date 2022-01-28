package com.yjlan.im.deliverer.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.SendDelivererRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.deliverer.session.GatewaySessionManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description 请求处理器
 * @date 2022.01.26 15:46
 */
@Component
public class SendDelivererRequestProcessor implements DelivererMessageProcessor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SendDelivererRequestProcessor.class);
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        SendDelivererRequest request = (SendDelivererRequest) message.getBody();
        LOGGER.info("instanceCode:{}",request.getInstanceCode());
        GatewaySessionManager.put(request.getInstanceCode(),(SocketChannel)ctx.channel());
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.SEND_DELIVERER_REQUEST.getMessageType();
    }
}
