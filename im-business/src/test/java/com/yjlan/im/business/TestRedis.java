package com.yjlan.im.business;

import javax.annotation.Resource;

import com.yjlan.im.business.common.SaveMessageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.entity.StoreMessage;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Resource
    private SaveMessageUtils saveMessageUtils;
    
    @Test
    public void testSortedSet() {
        String key = RedisPrefixConstant.IM_MESSAGE + 2
                + "-" + 1;
        StoreMessage storeMessage = new StoreMessage();
        storeMessage.setTimeStamp(1643438100502L);
        storeMessage.setSendContent("say hi");
        String sendContent =JSONObject.toJSONString(storeMessage);
        redisTemplate.opsForZSet().remove(key,sendContent);
    }

    @Test
    public void testApi() {
        Long count = redisTemplate.opsForZSet().zCard(saveMessageUtils.getKey(3L));
        System.out.println(count);
        HashSet<ZSetOperations.TypedTuple<String>> maxScoreSet = (HashSet<ZSetOperations.TypedTuple<String>>)redisTemplate.opsForZSet().rangeWithScores(saveMessageUtils.getKey(3L), 3, 3);
        assert maxScoreSet != null;
        for (ZSetOperations.TypedTuple<String> stringTypedTuple : maxScoreSet) {
            System.out.println(Objects.requireNonNull(stringTypedTuple.getScore()).longValue() + stringTypedTuple.getValue());
        }
    }
}
