package com.yjlan.im.business.offlinemessage.service;

import com.yjlan.im.business.api.dto.FetchOffLineMessageDTO;
import com.yjlan.im.business.api.vo.OffLineMessageVO;

/**
 * 离线消息Service
 * @author yjlan
 */
public interface OffLineMessageService {


    /**
     * 查询离线消息
     * @param dto 请求参数
     * @return 查询的离线消息
     * */
    OffLineMessageVO listOffLineMessage(FetchOffLineMessageDTO dto);

}
