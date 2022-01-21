package com.yjlan.im.common.route;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.yjlan.im.common.exception.ImException;

/**
 * @author yjlan
 * @version V1.0
 * @Description 轮询算法
 * @date 2022.01.21 16:48
 */
public class RoundRobinHandle implements ChooseServerHandle {
    
    private final AtomicLong index = new AtomicLong();
    
    @Override
    public String chooseServer(List<String> serverList, String key) {
        if (serverList.size() == 0) {
            throw new ImException("当前没有任何可以选择的服务器") ;
        }
        long position = index.incrementAndGet() % serverList.size();
        if (position < 0) {
            position = 0L;
        }
    
        return serverList.get((int) position);
    }
}
