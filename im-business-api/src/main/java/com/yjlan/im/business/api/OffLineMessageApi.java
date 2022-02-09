package com.yjlan.im.business.api;

import com.yjlan.im.business.api.dto.FetchOffLineMessageDTO;
import com.yjlan.im.business.api.vo.OffLineMessageVO;
import com.yjlan.im.common.result.ResponseResult;

/**
 * 离线消息 api
 * @author yjlan
 */
public interface OffLineMessageApi {

    /**
     * 通过用户id和上次的分数查询对应的离线群消息
     * @param dto 请求参数
     * @return 返回离线消息
     */
    ResponseResult<OffLineMessageVO> listOffLineGroupMessage(FetchOffLineMessageDTO dto);
}
