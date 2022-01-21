package com.yjlan.im.common.exception;

import com.yjlan.im.common.constants.ImBusinessCode;

/**
 * @author yjlan
 * @version V1.0
 * @Description 业务异常类
 * @date 2022.01.21 16:49
 */
public class ImException extends BaseException{
    private static final long serialVersionUID = 1L;
    
    public ImException(Integer code, String message) {
        super(code, message);
    }
    
    public ImException(String message) {
        super(ImBusinessCode.COMMON_EXCEPTION_CODE, message);
    }
    
    
}
