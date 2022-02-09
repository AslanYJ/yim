package com.yjlan.im.business.offlinemessage.controller;

import com.yjlan.im.business.api.OffLineMessageApi;
import com.yjlan.im.business.api.dto.FetchOffLineMessageDTO;
import com.yjlan.im.business.api.vo.OffLineMessageVO;
import com.yjlan.im.business.offlinemessage.service.OffLineMessageService;
import com.yjlan.im.common.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 离线群消息
 * @author yjlan
 */
@RestController
@RequestMapping("/offLineMessage/")
@Api(tags = "离线消息")
public class OffLineMessageController implements OffLineMessageApi {

    @Resource
    private OffLineMessageService offLineMessageService;


    @ApiOperation(value = "查询离线消息")
    @PostMapping("listOffLineMessage")
    @Override
    public ResponseResult<OffLineMessageVO> listOffLineGroupMessage(@Validated @RequestBody FetchOffLineMessageDTO dto) {
        OffLineMessageVO vo = offLineMessageService.listOffLineMessage(dto);
        return ResponseResult.success(vo);
    }
}
