package com.yjlan.im.business;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.entity.StoreMessage;

/**
 * @author yjlan
 * @version V1.0
 * @Description redis测试类
 * @date 2022.01.29 14:15
 */
@SpringBootTest(classes = BusinessApplication.class)
@RunWith(SpringRunner.class)
public class TestRedis {
    
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    
    @Test
    public void testSortedSet() {
        String key = RedisPrefixConstant.GROUP_MESSAGE + 2
                + "-" + 1;
        StoreMessage storeMessage = new StoreMessage();
        storeMessage.setTimeStamp(1643438100502L);
        storeMessage.setSendContent("say hi");
        String sendContent =JSONObject.toJSONString(storeMessage);
        redisTemplate.opsForZSet().remove(key,sendContent);
    }
}
