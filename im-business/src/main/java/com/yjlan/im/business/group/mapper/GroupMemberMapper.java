package com.yjlan.im.business.group.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjlan.im.business.group.entity.GroupMember;

public interface GroupMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupMember record);

    int insertSelective(GroupMember record);

    GroupMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupMember record);

    int updateByPrimaryKey(GroupMember record);
    
    /**
     * 查询群成员
     * @param groupId 群id
     * @param timeStamp 时间戳
     * @return 返回对应的数据
     */
    List<GroupMember> listGroupMember(@Param("groupId") Long groupId, @Param("timeStamp") Date timeStamp);
}