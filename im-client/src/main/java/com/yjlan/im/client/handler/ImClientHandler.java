package com.yjlan.im.client.handler;

import com.yjlan.im.client.processor.ClientMessageProcessorFactory;
import com.yjlan.im.common.protocol.MessageHeader;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yjlan.im.common.protocol.MessageProtocol;
import com.yjlan.im.common.utils.SpringBeanFactory;

/**
 * @author yjlan
 * @version V1.0
 * @Description client的处理handler
 * @date 2022.01.20 15:36
 *
 * */

public class ImClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ImClientHandler.class);

    

    /**
     * 收到服务器的响应
     * @param ctx 对应的channel
     * @param messageProtocol 消息
     * @throws Exception 异常
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageProtocol messageProtocol) throws Exception {
        MessageHeader header = messageProtocol.getHeader();
        // 推送消息的请求
//        if (header.getMessageType() == MessageTypeManager.MESSAGE_PUSH_REQUEST.getMessageType()) {
//            MessagePushRequest messagePushRequest = (MessagePushRequest) messageProtocol.getBody();
//            LOGGER.info("receive message messageId:{},senderId:{},receiverId:{},sendContent:{}",
//                    messagePushRequest.getMessageId(),
//                    messagePushRequest.getSenderId(),
//                    messagePushRequest.getReceiverId(),
//                    messagePushRequest.getSendContent());
//            // 直接返回一个Response
//            MessagePushResponse messagePushResponse = MessagePushResponse.newBuilder()
//                    .setCode(ImBusinessCode.MESSAGE_READ_SUCCESS)
//                    .setMessageId(messagePushRequest.getMessageId())
//                    .setMessage("消息读取成功！")
//                    .build();
//            MessageProtocolUtils.sendMsg((SocketChannel) ctx.channel(),messagePushResponse);
//        } else if (header.getMessageType() == MessageTypeManager.MESSAGE_SEND_RESPONSE.getMessageType()) {
//            MessageSendResponse messageSendResponse = (MessageSendResponse) messageProtocol.getBody();
//            LOGGER.info("get send message response,msg:{}",messageSendResponse.toString());
//        }
        ClientMessageProcessorFactory clientMessageProcessorFactory = SpringBeanFactory.getBean(ClientMessageProcessorFactory.class);
        clientMessageProcessorFactory.getProcessor(header.getMessageType()).process(messageProtocol,ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端和服务端建立连接时调用
        LOGGER.info("client和gateway 连接成功!");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("client 和服务器断开连接");
        // todo 重新连接
    }

}
