package com.yjlan.im.business;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yjlan.im.business.group.dto.CreateGroupDTO;
import com.yjlan.im.business.group.entity.GroupInfo;
import com.yjlan.im.business.group.service.GroupService;

/**
 * @author yjlan
 * @version V1.0
 * @Description TestGroupInfoServie
 * @date 2022.01.27 16:51
 */
@SpringBootTest(classes = BusinessApplication.class)
@RunWith(SpringRunner.class)
public class TestGroupService {
    @Resource
    private GroupService groupService;
    
    @Test
    public void testCreateGroup() {
        CreateGroupDTO createGroupDTO = new CreateGroupDTO();
        createGroupDTO.setGroupName("10人上限群");
        createGroupDTO.setCreatorId(1L);
        createGroupDTO.setMaxMemberNum(10);
        groupService.createGroup(createGroupDTO);
    }
}
