package com.yjlan.im.business.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 拉取离线群消息
 * @author yjlan
 */
public class FetchOffLineMessageDTO {

    @NotNull
    @Min(1)
    private Long userId;
    
    
    @NotNull
    private Double lastFetchMinScore;

    @NotNull
    private Double lastFetchMaxScore;

    

    @NotNull
    @Min(1)
    private Integer size;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
    public Double getLastFetchMinScore() {
        return lastFetchMinScore;
    }
    
    public void setLastFetchMinScore(Double lastFetchMinScore) {
        this.lastFetchMinScore = lastFetchMinScore;
    }
    
    public Double getLastFetchMaxScore() {
        return lastFetchMaxScore;
    }
    
    public void setLastFetchMaxScore(Double lastFetchMaxScore) {
        this.lastFetchMaxScore = lastFetchMaxScore;
    }
    
    @Override
    public String toString() {
        return "FetchOffLineGroupMessageDTO{" +
                "userId=" + userId +
                ", lastFetchMinScore=" + lastFetchMinScore +
                ", lastFetchMaxScore=" + lastFetchMaxScore +
                ", size=" + size +
                '}';
    }
}
