package com.yjlan.im.common.route;

import java.util.List;

/**
 * @author yjlan
 * @version V1.0
 * @Description 选择一台服务器算法(可以通过配置文件修改策略)
 * @date 2022.01.21 16:42
 */
public interface ChooseServerHandle {
    
    /**
     * 选择一台服务器
     * @param serverList 选择一台服务器
     * @param key 关键字
     * @return 返回一台服务器
     */
    String chooseServer(List<String> serverList,String key);
}
