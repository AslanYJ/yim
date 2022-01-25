package com.yjlan.im.dispatcher.service.processor;

import javax.annotation.Resource;

import com.yjlan.im.common.utils.ChannelIdUtils;
import com.yjlan.im.dispatcher.constants.RedisPrefixConstant;
import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.socket.SocketChannel;
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
        LOGGER.info("认证请求处理,authMessage :{}",message.toString());
        AuthenticateRequest request = (AuthenticateRequest) message.getBody();
        boolean authenticate = ssoService.authenticate(request);
        if (authenticate) {
            //    // 其实在这里应该把session信息写入Redis的
            //            String sessionKey = "session_" + authenticateRequest.getUid();
            //            String sessionValue= "{"
            //                    + "'token':'" + authenticateRequest.getToken() + "',"
            //                    + "'timestamp':" + authenticateRequest.getTimestamp() + ","
            //                    + "'isAuthenticated':'true',"
            //                    + "'authenticateTimestamp':" + System.currentTimeMillis() + ","
            //                    + "'gatewayChannelId': '" + gatewayChannelId + "'"
            //                    + "}";
            // 认证成功后，将会话存到存入redis中
            saveSession(request, ChannelIdUtils.getChannelId((SocketChannel) ctx.channel()));
        }
 
    }

    private void saveSession(AuthenticateRequest request,String gatewayChannelId) {
        
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
                + request.getUid(),"token",request.getToken());
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
                + request.getUid(),"timestamp",String.valueOf(request.getTimestamp()));
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
        + request.getUid(),"isAuthenticated",String.valueOf(true));
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
        + request.getUid(),"gatewayChannelId",gatewayChannelId);

    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.AUTHENTICATE_REQUEST.getMessageType();
    }
}
