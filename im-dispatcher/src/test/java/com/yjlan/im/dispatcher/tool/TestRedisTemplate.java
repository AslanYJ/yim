package com.yjlan.im.dispatcher.tool;

import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.dispatcher.DispatcherApplication;
import com.yjlan.im.dispatcher.constants.RedisPrefixConstant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 测试Redis
 * @author yjlan
 */
@SpringBootTest(classes = DispatcherApplication.class)
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("test","test");
        String value = redisTemplate.opsForValue().get("test");
        System.out.println("====" + value);
    }
    
    @Test
    public void testHash() {
        AuthenticateRequest request = AuthenticateRequest.newBuilder()
                .setUid("f")
                .setToken("testToken")
                .setTimestamp(System.currentTimeMillis())
                .build();
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
                + request.getUid(),"token",request.getToken());
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
                + request.getUid(),"timestamp",String.valueOf(request.getTimestamp()));
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
                + request.getUid(),"isAuthenticated",String.valueOf(true));
        redisTemplate.opsForHash().put(RedisPrefixConstant.USER_SESSION
                + request.getUid(),"gatewayChannelId","test");
    }
}
