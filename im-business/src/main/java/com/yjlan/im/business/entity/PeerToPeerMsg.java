package com.yjlan.im.business.entity;

import java.util.Date;

public class PeerToPeerMsg {
    private Long id;

    private String senderId;

    private String receiverId;

    private Byte isReaded;

    private Date gmtCreate;

    private Date gmtUpdate;

    private String sendContent;

    public PeerToPeerMsg(Long id, String senderId, String receiverId, Byte isReaded, Date gmtCreate, Date gmtUpdate, String sendContent) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.isReaded = isReaded;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
        this.sendContent = sendContent;
    }

    public PeerToPeerMsg() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId == null ? null : senderId.trim();
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
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