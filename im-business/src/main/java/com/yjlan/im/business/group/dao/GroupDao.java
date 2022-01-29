package com.yjlan.im.business.group.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yjlan.im.business.group.entity.GroupInfo;
import com.yjlan.im.business.group.entity.GroupMember;
import com.yjlan.im.business.group.entity.SendToGroupMsg;
import com.yjlan.im.business.group.mapper.GroupInfoMapper;
import com.yjlan.im.business.group.mapper.GroupMemberMapper;
import com.yjlan.im.business.group.mapper.SendToGroupMsgMapper;

/**
 * @author yjlan
 * @version V1.0
 * @Description 和所有群相关的dao层
 * @date 2022.01.27 14:46
 */
@Repository
public class GroupDao {
    
    @Resource
    private GroupInfoMapper groupInfoMapper;
    
    @Resource
    private GroupMemberMapper groupMemberMapper;
    
    @Resource
    private SendToGroupMsgMapper sendToGroupMsgMapper;
    
    public void saveGroupInfo(GroupInfo groupInfo) {
        groupInfoMapper.insertSelective(groupInfo);
    }
    
    public void saveGroupMember(GroupMember groupMember) {
        groupMemberMapper.insertSelective(groupMember);
    }
    
    public List<GroupMember> listGroupMember(Long groupId, Date date) {
        return groupMemberMapper.listGroupMember(groupId,date);
    }
    
    public void saveGroupMessage(SendToGroupMsg sendToGroupMsg) {
        sendToGroupMsgMapper.insertSelective(sendToGroupMsg);
    }
}
