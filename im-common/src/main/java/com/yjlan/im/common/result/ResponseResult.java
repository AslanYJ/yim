package com.yjlan.im.common.result;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.exception.BaseException;

/**
 * @author yjlan
 * @version V1.0
 * @Description 返回类
 * @date 2022.01.27 14:50
 */
@ApiModel("统一返回数据结果")
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("返回码，200表示请求成功")
    private int code;
    
    @ApiModelProperty("返回信息，请求失败时为失败原因")
    private String message;
    
    @ApiModelProperty("返回数据")
    private T data;
    
    public ResponseResult() {
        this.code = ImBusinessCode.RESPONSE_SUCCESS_CODE;
        this.message = "success";
    }
    
    public ResponseResult(BaseException exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }
    
    public ResponseResult(int code, String msg) {
        this.code = code;
        this.message = msg;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public static <T> ResponseResult<T> success() {
        return success(null);
    }
    
    public static <T> ResponseResult<T> success(T t) {
        ResponseResult<T> result = new ResponseResult();
        result.setData(t);
        result.setMessage("success");
        result.setCode(ImBusinessCode.RESPONSE_SUCCESS_CODE);
        return result;
    }
    
    public static <T> ResponseResult<T> fail(String message) {
        return fail(ImBusinessCode.RESPONSE_FAIL_CODE, message, null);
    }
    
    
    
    public static <T> ResponseResult<T> fail(Integer code, String message) {
        return fail(code, message, null);
    }
    
    public static <T> ResponseResult<T> fail(Integer code, String message, T t) {
        ResponseResult<T> result = new ResponseResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(t);
        return result;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    @JsonIgnore
    public boolean isSuccess() {
        return Objects.equals(this.getCode(), ImBusinessCode.RESPONSE_SUCCESS_CODE);
    }
}
