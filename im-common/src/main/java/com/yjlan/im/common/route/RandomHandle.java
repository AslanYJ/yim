package com.yjlan.im.common.route;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.util.CollectionUtils;

import com.yjlan.im.common.exception.ImException;

/**
 * @author yjlan
 * @version V1.0
 * @Description 随机算法
 * @date 2022.01.21 17:09
 */
public class RandomHandle implements ChooseServerHandle{
    
    @Override
    public String chooseServer(List<String> serverList, String key) {
        if (CollectionUtils.isEmpty(serverList)) {
            throw new ImException("当前没有任何可以选择的服务器") ;
        }
        int index = ThreadLocalRandom.current().nextInt(serverList.size());
        return serverList.get(index);
    }
}
