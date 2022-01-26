package com.yjlan.im.gateway.processor;

import javax.annotation.Resource;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.gateway.dispatcher.DispatcherManager;
import com.yjlan.im.gateway.session.SessionManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description 认证请求处理器
 * @date 2022.01.24 14:25
 */
@Component
public class AuthenticateRequestProcessor implements MessageProcessor {
    
    @Resource
    private DispatcherManager dispatcherManager;
    
    @Value("${instance.code}")
    private String instanceCode;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticateRequestProcessor.class);
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        AuthenticateRequest requestFromClient = (AuthenticateRequest) message.getBody();
        LOGGER.info("auth msg :{}",requestFromClient.toString());
        // 这里如果认证通过的话，会在dispatcher中增加一个缓存
        AuthenticateRequest requestToDispatcher = AuthenticateRequest.newBuilder()
                .setInstanceCode(instanceCode)
                .setTimestamp(requestFromClient.getTimestamp())
                .setToken(requestFromClient.getToken())
                .setUid(requestFromClient.getUid())
                .build();
        dispatcherManager.forwardToDispatcher((SocketChannel) ctx.channel(),requestToDispatcher);
        SessionManager.put(requestToDispatcher.getUid(),(SocketChannel) ctx.channel());
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.AUTHENTICATE_REQUEST.getMessageType();
    }
}
