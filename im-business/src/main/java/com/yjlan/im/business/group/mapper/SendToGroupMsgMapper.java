package com.yjlan.im.business.group.mapper;

import com.yjlan.im.business.group.entity.SendToGroupMsg;

public interface SendToGroupMsgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SendToGroupMsg record);

    int insertSelective(SendToGroupMsg record);

    SendToGroupMsg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SendToGroupMsg record);

    int updateByPrimaryKeyWithBLOBs(SendToGroupMsg record);

    int updateByPrimaryKey(SendToGroupMsg record);
}