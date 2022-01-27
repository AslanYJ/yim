package com.yjlan.im.business.mapper;

import com.yjlan.im.business.entity.PeerToPeerMsg;

public interface PeerToPeerMsgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PeerToPeerMsg record);

    int insertSelective(PeerToPeerMsg record);

    PeerToPeerMsg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PeerToPeerMsg record);

    int updateByPrimaryKeyWithBLOBs(PeerToPeerMsg record);

    int updateByPrimaryKey(PeerToPeerMsg record);
}