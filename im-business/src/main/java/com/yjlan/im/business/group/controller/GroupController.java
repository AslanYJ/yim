package com.yjlan.im.business.group.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjlan.im.business.common.ResponseResult;
import com.yjlan.im.business.group.dto.CreateGroupDTO;
import com.yjlan.im.business.group.service.GroupService;

/**
 * @author yjlan
 * @version V1.0
 * @Description 群聊相关接口
 * @date 2022.01.27 14:32
 */
@RestController
@RequestMapping("/group/")
@Api(tags = "群聊相关接口")
public class GroupController {
    
    @Resource
    private GroupService groupService;
    
    @PostMapping("createGroup")
    @ApiOperation(value = "创建一个群")
    public ResponseResult<Void> createGroup(@Valid @RequestBody CreateGroupDTO createGroupDTO) {
        groupService.createGroup(createGroupDTO);
        return ResponseResult.success();
    }
}
