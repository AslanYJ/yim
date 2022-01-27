package com.yjlan.im.business.group.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yjlan.im.business.group.entity.GroupInfo;
@Mapper
public interface GroupInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupInfo record);

    int insertSelective(GroupInfo record);

    GroupInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupInfo record);

    int updateByPrimaryKey(GroupInfo record);
}