package com.yjlan.im.business.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 拉取离线群消息
 * @author yjlan
 */
public class FetchOffLineGroupMessageDTO {

    @NotNull
    @Size(min = 1)
    private Long userId;

    @NotNull
    private Long lastFetchMaxScore;

    @NotNull
    private Long maxScore;

    @NotNull
    @Size(min = 1)
    private Integer size;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLastFetchMaxScore() {
        return lastFetchMaxScore;
    }

    public void setLastFetchMaxScore(Long lastFetchMaxScore) {
        this.lastFetchMaxScore = lastFetchMaxScore;
    }

    public Long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Long maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
