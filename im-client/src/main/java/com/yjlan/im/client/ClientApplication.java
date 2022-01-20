package com.yjlan.im.client;

import com.yjlan.im.client.scan.ScanWorker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yjlan
 * @version V1.0
 * @Description 客户端
 * @date 2022.01.20 15:36
 */
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // 初始化窗口
        ScanWorker scanWorker = new ScanWorker();
        scanWorker.setName("scanWorker-thread");
        scanWorker.start();
    }
}
