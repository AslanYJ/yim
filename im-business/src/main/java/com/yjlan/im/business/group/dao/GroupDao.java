package com.yjlan.im.business.group.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yjlan.im.business.group.entity.GroupInfo;
import com.yjlan.im.business.group.mapper.GroupInfoMapper;

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
    
    public void save(GroupInfo groupInfo) {
        groupInfoMapper.insertSelective(groupInfo);
    }
}
