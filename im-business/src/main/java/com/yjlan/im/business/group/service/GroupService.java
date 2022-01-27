package com.yjlan.im.business.group.service;

import com.yjlan.im.business.group.dto.CreateGroupDTO;

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
}
