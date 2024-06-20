package com.yjlan.im.client.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;

/**
 * @author yjlan
 * @version V1.0
 * @Description Bean的初始化
 * @date 2022.02.09 15:56
 */
@Configuration
public class BeanConfig {
    
    /**
     * http 请求的bean
     * @return http请求的组件
     */
    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        return builder.build();
    }
}
