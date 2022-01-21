package com.yjlan.im.common.exception;

/**
 * @author yjlan
 * @version V1.0
 * @Description 基础异常
 * @date 2022.01.21 16:52
 */
public class BaseException extends RuntimeException{
    private Integer code;
    private String message;
    
    public BaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
