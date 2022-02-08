package com.yjlan.im.business.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yjlan.im.common.result.ResponseResult;
import com.yjlan.im.common.exception.ImException;

/**
 * @author yjlan
 * @version V1.0
 * @Description 统一异常处理
 * @date 2022.01.28 08:59
 */
@RestControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAdvice {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);
    
    @ExceptionHandler(value = ImException.class)
    public ResponseResult<Void> customException(ImException e) {
        LOGGER.error("handle error,code:{},message:{}",e.getCode(),e.getMessage());
        return ResponseResult.fail(e.getCode(),e.getMessage());
    }
}
