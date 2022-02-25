package com.yjlan.im.business.async.listener;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.async.AsyncContext;
import com.yjlan.async.annotation.Channel;
import com.yjlan.async.event.BaseEvent;
import com.yjlan.async.listener.EventListener;
import com.yjlan.async.thread.ExecutorService;
import com.yjlan.im.business.async.ChannelKey;
import com.yjlan.im.business.async.PrintContext;
import com.yjlan.im.business.async.event.Print3Event;

/**
 * @author yjlan
 * @version V1.0
 * @Description (这里用一句话描述这个类的作用)
 * @date 2022.02.24 16:27
 */
@Component
@Channel(ChannelKey.PRINT3_CHANNEL)
public class Print3Listener implements EventListener<Print3Event> {
    
    @Resource
    private ExecutorService executorService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Print3Listener.class);
    
  
    
    @Override
    public boolean accept(BaseEvent baseEvent) {
        return baseEvent instanceof Print3Event;
    }
    
    @Override
    public void execute(Print3Event print3Event, AsyncContext asyncContext) {
        PrintContext printContext = (PrintContext) asyncContext;
        LOGGER.info("最后一步，打印完毕");
        LOGGER.info("信息--------------------- msg:{}",printContext.getContent());
        executorService.execute(ChannelKey.PRINT3_CHANNEL,() -> {
            LOGGER.info("结束咯");
        });
    }
}
