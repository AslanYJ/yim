package com.yjlan.im.business.group.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.util.MappingUtils;
import com.yjlan.im.business.group.dao.GroupDao;
import com.yjlan.im.business.group.dto.CreateGroupDTO;
import com.yjlan.im.business.group.entity.GroupInfo;
import com.yjlan.im.business.group.service.GroupService;
import com.yjlan.im.common.utils.ConvertBeanUtils;

/**
 * @author yjlan
 * @version V1.0
 * @Description GroupService的实现类
 * @date 2022.01.27 16:28
 */
@Service
public class GroupServiceImpl implements GroupService {
    
    @Resource
    private GroupDao groupDao;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createGroup(CreateGroupDTO createGroupDTO) {
        GroupInfo groupInfo = new GroupInfo();
        ConvertBeanUtils.convertor(createGroupDTO,groupInfo);
        groupDao.save(groupInfo);
    }
}
