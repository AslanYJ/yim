package com.yjlan.im.business.group.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yjlan
 * @version V1.0
 * @Description (这里用一句话描述这个类的作用)
 * @date 2022.01.27 15:30
 */
@ApiModel("新建一个群")
public class CreateGroupDTO {
    
    @ApiModelProperty("群名称")
    @NotBlank
    private String groupName;
    
    @ApiModelProperty("群上限人数")
    @NotNull
    @Max(500)
    @Min(1)
    private Integer maxMemberNum;
    
    @NotNull
    @Min(value =1,message = "userId要大于1")
    private Long creatorId;
    
    public Long getCreatorId() {
        return creatorId;
    }
    
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public Integer getMaxMemberNum() {
        return maxMemberNum;
    }
    
    public void setMaxMemberNum(Integer maxMemberNum) {
        this.maxMemberNum = maxMemberNum;
    }
    
    @Override
    public String toString() {
        return "CreateGroupDTO{" +
                "groupName='" + groupName + '\'' +
                ", maxMemberNum=" + maxMemberNum +
                '}';
    }
}
