package com.yjlan.im.client.scan;

import com.yjlan.im.client.client.IMNettyClient;
import com.yjlan.im.common.utils.SpringBeanFactory;

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

    private IMNettyClient imNettyClient;

    public ScanWorker() {
        this.imNettyClient = SpringBeanFactory.getBean(IMNettyClient.class);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();
            imNettyClient.sendMsg(msg);
            LOGGER.info("msg :{}",msg);
        }
    }
}
