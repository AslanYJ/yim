package com.yjlan.im.business.annotation;

import com.yjlan.im.business.aop.RetryFallbackFactory;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RetryOnFailure {
    /**
     * 重试次数
     * @return 重试次数
     */
    int maxAttempts() default 3;

    /**
     * 重试间隔
     * @return 间隔
     */
    long delayMillis() default 1000;


    TimeUnit delayTimeType() default TimeUnit.MILLISECONDS;

    /**
     * 处理的异常类
     * @return 异常类型
     */
    Class<? extends Throwable>[] retryOnExceptions() default {};

    Class<?> fallbackFactory() default Void.class;
}
