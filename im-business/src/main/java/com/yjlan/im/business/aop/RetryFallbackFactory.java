package com.yjlan.im.business.aop;

public interface RetryFallbackFactory<T> {
    T create(Throwable cause);
}