package com.yjlan.im.gateway;

import com.yjlan.im.gateway.scan.ScanWorker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yjlan
 * @version V1.0
 * @Description 传输层
 * @date 2022.01.20 15:47
 */
@SpringBootApplication(scanBasePackages = "com.yjlan.im.*")
public class GatewayApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        ScanWorker scanWorker = new ScanWorker();
        scanWorker.start();
    }
}
