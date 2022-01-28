package com.yjlan.im.client.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.constants.Constant;

/**
 * @author yjlan
 * @version V1.0
 * @Description 请求处理工厂
 * @date 2022.01.28 11:27
 */
@Component
public class ClientMessageProcessorFactory implements InitializingBean, ApplicationContextAware {
    
    private static final Map<Integer,ClientMessageProcessor> PROCESSOR_MAP
            = new HashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);
    
    private ApplicationContext applicationContext;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(ClientMessageProcessor.class)
                .values().forEach(e -> PROCESSOR_MAP.put(e.getMessageType(),e));
    }
    
    public ClientMessageProcessor getProcessor(Integer messageType) {
        return PROCESSOR_MAP.get(messageType);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
