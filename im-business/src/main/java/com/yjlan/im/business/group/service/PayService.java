package com.yjlan.im.business.group.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Slf4j
public class PayService {
    private final int totalNum = 100000;

    //@Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public int minGoodsNum(int num) {
        log.info("减库存开始=>" + LocalTime.now());
        log.info("库存=>" + totalNum);
        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        log.info("减库存执行结束=>" + LocalTime.now());
        return totalNum - num;
    }

    /**
     * 使用@Recover注解，当重试次数达到设置的次数的时候，还是失败抛出异常，执行的回调函数。
     */
    //@Recover
    public int recover(Exception e) {
        log.warn("减库存失败！！！" + LocalTime.now());
        //记日志到数据库
        return totalNum;
    }
}
