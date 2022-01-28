package com.yjlan.im.business.group.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yjlan
 * @version V1.0
 * @Description 加入群DTO
 * @date 2022.01.28 09:12
 */
@ApiModel(value = "加入群")
public class JoinGroupDTO {
    
    @ApiModelProperty(value = "用户id")
    @NotNull(message = "不能为null")
    @Size(min = 1,message = "userId不能小于0")
    private Long userId;
    
    
    @ApiModelProperty(value = "需要加入的群id")
    @NotNull(message = "groupId不能为null")
    @Size(min = 1,message = "groupId大于0")
    private Long groupId;
    
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getGroupId() {
        return groupId;
    }
    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    
    @Override
    public String toString() {
        return "JoinGroupDTO{" +
                "userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}
