package com.yjlan.im.business.group.entity;

import java.util.Date;

public class SendToGroupMsg {
    private Long id;

    private Long senderId;

    private Long groupId;

    private Long receiverId;

    private Byte isReaded;

    private Date gmtCreate;

    private Date gmtUpdate;

    private String sendContent;

    public SendToGroupMsg(Long id, Long senderId, Long groupId, Long receiverId, Byte isReaded, Date gmtCreate, Date gmtUpdate, String sendContent) {
        this.id = id;
        this.senderId = senderId;
        this.groupId = groupId;
        this.receiverId = receiverId;
        this.isReaded = isReaded;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
        this.sendContent = sendContent;
    }

    public SendToGroupMsg() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Byte getIsReaded() {
        return isReaded;
    }

    public void setIsReaded(Byte isReaded) {
        this.isReaded = isReaded;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public String getSendContent() {
        return sendContent;
    }

    public void setSendContent(String sendContent) {
        this.sendContent = sendContent == null ? null : sendContent.trim();
    }
}