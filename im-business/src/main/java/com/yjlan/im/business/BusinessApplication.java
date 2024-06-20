package com.yjlan.im.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * 业务启动器。
 * 包含多中业务逻辑，更优雅的方式是将不用的功能独立成 不同的服务
 *
 * @author yjlan
 */
@SpringBootApplication(scanBasePackages = "com.yjlan")
@MapperScan(basePackages = {"com.yjlan.**.mapper*"})
@EnableRetry
public class BusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class);

    }
}
