package com.yjlan.im.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yjlan
 * @version V1.0
 * @Description Client端的一些配置
 * @date 2022.01.24 11:50
 */
@Component
public class ClientConfig {
    
    @Value("${connect.gateway.ip}")
    private String ip;
    
    @Value("${connect.gateway.port}")
    private Integer port;
    
    
    @Value("${userId}")
    private String userId;
    
    @Value("${userName}")
    private String userName;
    
    public String getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public Integer getPort() {
        return port;
    }
    
    public String getIp() {
        return ip;
    }
}
