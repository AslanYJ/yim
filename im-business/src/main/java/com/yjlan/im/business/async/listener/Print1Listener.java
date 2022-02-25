package com.yjlan.im.business.async.listener;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yjlan.async.AsyncContext;
import com.yjlan.async.annotation.Channel;
import com.yjlan.async.event.BaseEvent;
import com.yjlan.async.eventbus.DispatcherEventBus;
import com.yjlan.async.listener.EventListener;
import com.yjlan.im.business.async.ChannelKey;
import com.yjlan.im.business.async.PrintEventHolder;
import com.yjlan.im.business.async.PrintContext;
import com.yjlan.im.business.async.event.Print1Event;

/**
 * @author yjlan
 * @version V1.0
 * @Description (这里用一句话描述这个类的作用)
 * @date 2022.02.24 16:27
 */
@Component
@Channel(ChannelKey.PRINT1_CHANNEL)
public class Print1Listener implements EventListener<Print1Event> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Print1Listener.class);
    
    @Resource
    private DispatcherEventBus dispatcherEventBus;
    
    @Override
    public boolean accept(BaseEvent baseEvent) {
        return baseEvent instanceof Print1Event;
    }
    
    @Override
    public void execute(Print1Event print1Event, AsyncContext asyncContext) {
        PrintContext printContext = (PrintContext) asyncContext;
        LOGGER.info("信息--------------------- msg:{}",printContext.getContent());
        printContext.setContent("Print1打印完毕，Print2打印");
        // 发布到下一个步骤
        dispatcherEventBus.publishEvent(PrintEventHolder.PRINT_2_EVENT,ChannelKey.PRINT2_CHANNEL,printContext);
    }
}
