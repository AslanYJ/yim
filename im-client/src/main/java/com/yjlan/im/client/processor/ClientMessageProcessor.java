package com.yjlan.im.client.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import com.yjlan.im.common.protocol.MessageProtocol;

/**
 * @author yjlan
 * @version V1.0
 * @Description 客户端的处理器
 * @date 2022.01.28 11:12
 */
public interface ClientMessageProcessor {
    
    /**
     * 接口定义
     * @param messageProtocol 请求/响应等等
     * @param ctx channel的管理器
     */
    void process(MessageProtocol messageProtocol, ChannelHandlerContext ctx);
    
    /**
     * 获取请求类型
     * @return 返回请求的处理类型
     */
    int getMessageType();
    
    
    
}
