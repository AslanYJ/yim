package com.yjlan.im.common.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.constants.ImBusinessCode;
import com.yjlan.im.common.exception.ImException;
import com.yjlan.im.common.utils.HttpClient;

import okhttp3.OkHttpClient;

/**
 * @author yjlan
 * @version V1.0
 * @Description 动态代理管理类
 * @date 2022.02.09 15:58
 */
public final class ProxyManager<T> {
    
    private String url;
    
    private OkHttpClient httpClient;
    
    private Class<T> clazz;
    
    
    public ProxyManager(String url, OkHttpClient httpClient, Class<T> clazz) {
        this.url = url;
        this.httpClient = httpClient;
        this.clazz = clazz;
    }
    
    @SuppressWarnings("unchecked")
    public T getInstance() {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{clazz},
                new ProxyInvocationHandler());
    }
    
    
    private  class ProxyInvocationHandler implements InvocationHandler {
    
        /**
         * 动态代理调用的方法
         * @param proxy 代理类实例
         * @param method 被调用的方法
         * @param args 调用参数
         * @return 调用结果
         * @throws Throwable 异常
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            JSONObject jsonObject = new JSONObject();
            String serverUrl = url + "/" + method.getName();
            if (args != null && args.length > 1) {
                throw new ImException(ImBusinessCode.VALIDATION_FAIL_CODE, "参数校验失败");
            }
            
            if (method.getParameterTypes().length > 0) {
                Object param = Objects.requireNonNull(args)[0];
                Class<?> parameterType = method.getParameterTypes()[0];
                for (Field field : parameterType.getDeclaredFields()) {
                    field.setAccessible(true);
                    jsonObject.put(field.getName(),field.get(param));
                }
            }
            //noinspection SuspiciousInvocationHandlerImplementation
            return HttpClient.call(httpClient, jsonObject.toJSONString(),serverUrl );
        }
    }
}
