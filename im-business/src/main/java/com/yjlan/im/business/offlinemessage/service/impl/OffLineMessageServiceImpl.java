package com.yjlan.im.business.offlinemessage.service.impl;

import com.alibaba.fastjson.JSON;
import com.yjlan.im.business.api.dto.FetchOffLineMessageDTO;
import com.yjlan.im.business.api.vo.OffLineMessageVO;
import com.yjlan.im.business.api.vo.OffLineMessageVO.OffLineMessage;
import com.yjlan.im.business.common.SaveMessageUtils;
import com.yjlan.im.business.offlinemessage.service.OffLineMessageService;
import com.yjlan.im.common.entity.StoreMessage;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public OffLineMessageVO listOffLineMessage(FetchOffLineMessageDTO dto) {
        String key = saveMessageUtils.getKey(dto.getUserId());
        OffLineMessageVO vo = new OffLineMessageVO();
        // 第一次拉取
        if (dto.getLastFetchMaxScore() == 0) {
            fetchMessage(vo,dto,key);
        } else {
            // 先删除上次拉取的消息
            Double lastFetchMinScore = dto.getLastFetchMinScore();
            Double lastFetchMaxScore = dto.getLastFetchMaxScore();
            Long removeResult = redisTemplate.opsForZSet().removeRangeByScore(key,lastFetchMinScore,lastFetchMaxScore);
            // 再次拉取指定数量的消息
            if (removeResult != null && removeResult > 0L) {
                fetchMessage(vo,dto,key);
            }
        }
        return vo;
    }
    
    /**
     * 拉取消息
     * @param vo 返回的消息VO
     * @param dto 请求参数
     * @param key key
     */
    private void fetchMessage(OffLineMessageVO vo, FetchOffLineMessageDTO dto,String key) {
        // 查询到所有的消息列表(根据score从小到大)
        Set<ZSetOperations.TypedTuple<String>> messageInfoSet = redisTemplate.opsForZSet().rangeWithScores(key, 0, -1);
        if (CollectionUtils.isEmpty(messageInfoSet)) {
            vo.setMessageList(Collections.emptyList());
            return;
        }
        List<OffLineMessage> messageList = new ArrayList<>(dto.getSize());
        int count = 0;
        boolean isFirst = true;
        // 第一次拉取，保存最大的分数和上一次的拉取分数
        for (TypedTuple<String> messageInfo : messageInfoSet) {
            String value = messageInfo.getValue();
            StoreMessage storeMessage = JSON.parseObject(value,StoreMessage.class);
            if (storeMessage != null) {
                if (isFirst) {
                    vo.setLastFetchMinScore(messageInfo.getScore());
                    isFirst = false;
                }
                OffLineMessage offLineMessage = new OffLineMessage();
                offLineMessage.setGroupId(storeMessage.getGroupId());
                offLineMessage.setTimeStamp(storeMessage.getTimeStamp());
                offLineMessage.setSendContent(storeMessage.getSendContent());
                messageList.add(offLineMessage);
                if (messageInfoSet.size() > dto.getSize()) {
                    count++;
                    vo.setLastFetchMaxScore(messageInfo.getScore());
                    if (count == dto.getSize()) {
                        break;
                    }
                } else {
                    vo.setLastFetchMaxScore(messageInfo.getScore());
                }
            }
        }
        vo.setMessageList(messageList);
    }
}
