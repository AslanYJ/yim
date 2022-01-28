package com.yjlan.im.deliverer.processor;

import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.constants.Constant;

/**
 * @author yjlan
 * @version V1.0
 * @Description 处理器工厂
 * @date 2022.01.24 14:42
 */
@Component
public class DelivererMessageProcessorFactory implements InitializingBean, ApplicationContextAware {
    
    private static final HashMap<Integer, DelivererMessageProcessor> PROCESSOR_MAP
            = new HashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);
    
    private ApplicationContext applicationContext;
    
    
    public DelivererMessageProcessor getMessageProcessor(Integer messageManagerType) {
        return PROCESSOR_MAP.get(messageManagerType);
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(DelivererMessageProcessor.class)
                .values().forEach(e -> PROCESSOR_MAP.put(e.getMessageManagerType(),e));
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
