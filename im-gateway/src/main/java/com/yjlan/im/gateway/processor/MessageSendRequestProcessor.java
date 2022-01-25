package com.yjlan.im.gateway.processor;

import javax.annotation.Resource;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import org.springframework.stereotype.Component;

import com.yjlan.im.common.proto.MessageSendRequest;
import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.protocol.MessageTypeManager;
import com.yjlan.im.gateway.dispatcher.DispatcherManager;

/**
 * @author yjlan
 * @version V1.0
 * @Description 发送消息转发器
 * @date 2022.01.24 14:33
 */
@Component
public class MessageSendRequestProcessor implements MessageProcessor{
    
    @Resource
    private DispatcherManager dispatcherManager;
    
    /**
     * 这里的ctx channel是 client的channel
     * @param message 请求/响应等等
     * @param ctx channel的管理器
     */
    @Override
    public void process(MessageProtocol message, ChannelHandlerContext ctx) {
        MessageSendRequest sendRequest = (MessageSendRequest) message.getBody();
        dispatcherManager.forwardToDispatcher((SocketChannel) ctx.channel(),sendRequest);
    }
    
    @Override
    public int getMessageManagerType() {
        return MessageTypeManager.MESSAGE_SEND_REQUEST.getMessageType();
    }
}
