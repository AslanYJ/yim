package com.yjlan.im.business.common;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.entity.StoreMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 保存消息的工具类
 * @author yjlan
 */
@Component
public class SaveMessageUtils {


    @Resource
    private RedisTemplate<String,String> redisTemplate;


    /**
     * 保存消息
     * @param userId 用户id
     * @param storeMessage 保存的消息
     */
    public void saveMessageToRedis(Long userId, StoreMessage storeMessage) {
        // 对于每一个群成员生成一个群消息
        String key = getKey(userId);
        redisTemplate.opsForZSet().add(key, JSONObject.toJSONString(storeMessage),Double.valueOf(storeMessage.getTimeStamp()));
    }


    /**
     * 获得对应的key
     * @param userId 用户id
     * @return 返回key
     */
    public String getKey(Long userId) {
        return RedisPrefixConstant.IM_MESSAGE + userId;
    }
}
