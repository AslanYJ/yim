package com.yjlan.im.business.group.entity;

import java.util.Date;

/**
 * group info entity
 * @author yjlan
 */
public class GroupInfo {
    private Long id;

    private String groupName;

    private Integer maxMemberNum;

    private Long creatorId;

    private Date gmtCreate;

    private Date gmtUpdate;

    public GroupInfo(Long id, String groupName, Integer maxMemberNum, Long creatorId, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.groupName = groupName;
        this.maxMemberNum = maxMemberNum;
        this.creatorId = creatorId;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }

    public GroupInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getMaxMemberNum() {
        return maxMemberNum;
    }

    public void setMaxMemberNum(Integer maxMemberNum) {
        this.maxMemberNum = maxMemberNum;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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
}