package com.yjlan.im.business.api.vo;

import java.util.List;

/**
 * 离线消息VO
 * @author yjlan
 */
public class OffLineMessageVO {

    /**
     * 返回的列表
     */
    private List<OffLineMessage> MessageList;

    /**
     * 上次拉取的最大分数
     */
    private Double lastFetchMaxScore;

    /**
     * 可拉取的最大分数
     */
    private Double maxScore;


    public static class OffLineMessage {
        /**
         * 群id。默认为0的话，就是单聊消息
         */
        private Long groupId;

        /**
         * 时间戳
         */
        private Long timeStamp;

        /**
         * 内容
         */
        private String sendContent;

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }

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
    }


    public List<OffLineMessage> getMessageList() {
        return MessageList;
    }

    public void setMessageList(List<OffLineMessage> messageList) {
        MessageList = messageList;
    }

    public Double getLastFetchMaxScore() {
        return lastFetchMaxScore;
    }

    public void setLastFetchMaxScore(Double lastFetchMaxScore) {
        this.lastFetchMaxScore = lastFetchMaxScore;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "OffLineGroupMessageVO{" +
                "MessageList=" + MessageList +
                ", lastFetchMaxScore=" + lastFetchMaxScore +
                ", maxScore=" + maxScore +
                '}';
    }
}
