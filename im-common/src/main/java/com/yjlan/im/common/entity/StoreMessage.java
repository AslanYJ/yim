package com.yjlan.im.common.entity;

/**
 * @author yjlan
 * @version V1.0
 * @Description 保存message的实体,单聊群聊都用这个
 * @date 2022.01.29 14:27
 */

public class StoreMessage {
    
    private Long timeStamp;
    
    private String sendContent;
    
    
    public Long getTimeStamp() {
        return timeStamp;
    }
    
    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public String getSendContent() {
        return sendContent;
    }
    
    public void setSendContent(String sendContent) {
        this.sendContent = sendContent;
    }
    
    @Override
    public String toString() {
        return "SendContent{" +
                "timeStamp=" + timeStamp +
                ", sendContent='" + sendContent + '\'' +
                '}';
    }
}
