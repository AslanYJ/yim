package com.yjlan.im.business.offlinemessage.service.impl;

import com.yjlan.im.business.api.dto.FetchOffLineGroupMessageDTO;
import com.yjlan.im.business.api.vo.OffLineMessageVO;
import com.yjlan.im.business.common.SaveMessageUtils;
import com.yjlan.im.business.offlinemessage.service.OffLineMessageService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 离线消息服务
 * @author yjlan
 */
@Service
public class OffLineMessageServiceImpl implements OffLineMessageService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private SaveMessageUtils saveMessageUtils;


    @Override
    public OffLineMessageVO listOffLineGroupMessage(FetchOffLineGroupMessageDTO dto) {
        // 查询SortedSet里面有
        String key = saveMessageUtils.getKey(dto.getUserId());
        Set<ZSetOperations.TypedTuple<String>> typedTuples = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, -1);
        return null;
    }
}
