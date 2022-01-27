package com.yjlan.im.business.group.entity;

import java.util.Date;

public class GroupMember {
    private Long id;

    private Long groupId;

    private Long userId;

    private Date joinTime;

    private Date gmtCerate;

    private Date gmtUpdate;

    public GroupMember(Long id, Long groupId, Long userId, Date joinTime, Date gmtCerate, Date gmtUpdate) {
        this.id = id;
        this.groupId = groupId;
        this.userId = userId;
        this.joinTime = joinTime;
        this.gmtCerate = gmtCerate;
        this.gmtUpdate = gmtUpdate;
    }

    public GroupMember() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getGmtCerate() {
        return gmtCerate;
    }

    public void setGmtCerate(Date gmtCerate) {
        this.gmtCerate = gmtCerate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}