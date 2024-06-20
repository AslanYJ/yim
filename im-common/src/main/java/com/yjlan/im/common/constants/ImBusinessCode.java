package com.yjlan.im.common.constants;

/**
 * @author yjlan
 * @version V1.0
 * @Description 各种状态类管理
 * @date 2022.01.21 16:56
 */
public class ImBusinessCode {
    
    /**
     * 正常返回响应的响应码
     */
    public static final int RESPONSE_SUCCESS_CODE = 200;
    
    public static final int RESPONSE_FAIL_CODE = -1;
    
    public static final int VALIDATION_FAIL_CODE = 4000;
    
    
    /**
     * 异常码
     */
    public static final int COMMON_EXCEPTION_CODE = 1000;
    
    /**
     * 认证失败
     */
    public static final int AUTHENTICATE_FAIL = 2001;

    /**
     * 消息已读
     */
    public static final int MESSAGE_READ_SUCCESS = 3000;

    public static final int MESSAGE_READ_FAIL = 3001;
    
    public static final int PUSH_MESSAGE_READ_SUCCESS = 4000;
}
