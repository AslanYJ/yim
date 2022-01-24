package com.yjlan.im.dispatcher.service.processor;

import io.netty.channel.ChannelHandlerContext;

import com.yjlan.im.common.protocol.MessageProtocol;

/**
 * @author yjlan
 * @version V1.0
 * @Description 消息处理接口定义
 * @date 2022.01.24 14:22
 */
public interface DispatcherMessageProcessor {
    
    /**
     * 接口定义
     * @param message 请求/响应等等
     * @param ctx channel的管理器
     */
    void process(MessageProtocol message, ChannelHandlerContext ctx);
    
    /**
     * 获得对应的类型
     * @return 消息类型
     */
    int getMessageManagerType();
}
