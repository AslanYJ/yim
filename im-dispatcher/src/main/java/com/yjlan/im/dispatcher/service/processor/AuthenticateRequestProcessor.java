package com.yjlan.im.dispatcher.service.processor;

import javax.annotation.Resource;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.dispatcher.service.sso.SsoService;

/**
 * @author yjlan
 * @version V1.0
 * @Description 认证请求处理器
 * @date 2022.01.24 14:25
 */
@Component
public class AuthenticateRequestProcessor implements DispatcherMessageProcessor {
    
    @Resource
    private SsoService ssoService;
    
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticateRequestProcessor.class);
    
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        AuthenticateRequest request = (AuthenticateRequest) message.getBody();
        boolean authenticate = ssoService.authenticate(request);
        if (authenticate) {
            // 存入redis中
            
        }
 
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.AUTHENTICATE_REQUEST.getMessageType();
    }
}
