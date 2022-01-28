package com.yjlan.im.business.group.service;

import java.util.Date;
import java.util.List;

import com.yjlan.im.business.group.dto.CreateGroupDTO;
import com.yjlan.im.business.group.dto.JoinGroupDTO;
import com.yjlan.im.business.group.entity.GroupMember;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群相关Service
 * @date 2022.01.27 16:28
 */
public interface GroupService {
    
    /**
     * 创建群组
     * @param createGroupDTO 请求参数
     */
    void createGroup(CreateGroupDTO createGroupDTO);
    
    /**
     * 加入群
     * @param joinGroupDTO 请求参数
     */
    void joinGroup(JoinGroupDTO joinGroupDTO);
    
    
    /**
     * 查询群成员
     * @param groupId 群id
     * @param date 时间戳
     * @return 返回群成员
     */
    List<GroupMember> listGroupMember(Long groupId, Date date);
}
