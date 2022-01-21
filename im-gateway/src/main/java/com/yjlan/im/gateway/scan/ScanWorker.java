package com.yjlan.im.gateway.scan;

import com.yjlan.im.common.utils.SpringBeanFactory;
import com.yjlan.im.gateway.server.GatewayNettyServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author yjlan
 * @version V1.0
 * @Description 窗口输入扫描
 * @date 2022.01.20 15:36
 *
 * */
public class ScanWorker extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScanWorker.class);

    private GatewayNettyServer gatewayNettyServer;

    public ScanWorker() {
        this.gatewayNettyServer = SpringBeanFactory.getBean(GatewayNettyServer.class);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();
            gatewayNettyServer.sendMsg(msg);
            LOGGER.info("msg :{}",msg);
        }
    }
}
