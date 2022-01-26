package com.yjlan.im.deliverer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消息推送服务
 * @author yjlan
 */
@SpringBootApplication(scanBasePackages = "com.yjlan.im.*")
public class DelivererApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelivererApplication.class);

    }
}
