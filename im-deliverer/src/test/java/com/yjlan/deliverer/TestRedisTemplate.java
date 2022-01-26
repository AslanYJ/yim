package com.yjlan.deliverer;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.deliverer.DelivererApplication;

/**
 * 测试Redis
 * @author yjlan
 */
@SpringBootTest(classes = DelivererApplication.class)
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
                .setUid("2")
                .setToken("testToken")
                .setTimestamp(System.currentTimeMillis())
                .build();
        String value = (String)redisTemplate.opsForHash().get(RedisPrefixConstant.USER_SESSION + request.getUid(),
                "gatewayChannelId");
        System.out.println(value);
    }
}
