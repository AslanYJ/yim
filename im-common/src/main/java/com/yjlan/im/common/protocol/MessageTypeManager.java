package com.yjlan.im.common.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.MessageLite;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.proto.AuthenticateResponse;
import com.yjlan.im.common.proto.GroupMessagePushRequest;
import com.yjlan.im.common.proto.GroupMessagePushResponse;
import com.yjlan.im.common.proto.GroupMessageSendRequest;
import com.yjlan.im.common.proto.GroupMessageSendResponse;
import com.yjlan.im.common.proto.MessagePushRequest;
import com.yjlan.im.common.proto.MessagePushResponse;
import com.yjlan.im.common.proto.MessageSendRequest;
import com.yjlan.im.common.proto.MessageSendResponse;
import com.yjlan.im.common.proto.SendDelivererRequest;
import com.yjlan.im.common.proto.SendDelivererResponse;

/**
 * @author yjlan
 * @version V1.0
 * @Description 消息类型的管理器
 * @date 2022.01.21 14:02
 */

public enum MessageTypeManager {
    /**
     * 权限认证请求
     */
    AUTHENTICATE_REQUEST(1, AuthenticateRequest.getDefaultInstance()),
    /**
     * 权限认证返回
     */
    AUTHENTICATE_RESPONSE(2, AuthenticateResponse.getDefaultInstance()),
    
    /**
     * 单聊请求发送
     */
    MESSAGE_SEND_REQUEST(3, MessageSendRequest.getDefaultInstance()),
    /**
     * 单聊请求返回
     *
     */
    MESSAGE_SEND_RESPONSE(4, MessageSendResponse.getDefaultInstance()),
    /**
     * 推送请求
     */
    MESSAGE_PUSH_REQUEST(5, MessagePushRequest.getDefaultInstance()),
    /**
     * 推送返回
     */
    MESSAGE_PUSH_RESPONSE(6, MessagePushResponse.getDefaultInstance()),
    /**
     * 发送一个连接给deliverer
     */
    SEND_DELIVERER_REQUEST(7, SendDelivererRequest.getDefaultInstance()),
    /**
     * 返回值，可能没用，先定义
     */
    SEND_DELIVERER_RESPONSE(8, SendDelivererResponse.getDefaultInstance()),
    
    /**
     * 群消息请求发送
     */
    GROUP_MESSAGE_SEND_REQUEST(9, GroupMessageSendRequest.getDefaultInstance()),
    
    /**
     * 群消息请求发送返回
     */
    GROUP_MESSAGE_SEND_RESPONSE(10, GroupMessageSendResponse.getDefaultInstance()),
    
    /**
     * 群消息推送
     */
    GROUP_MESSAGE_PUSH_REQUEST(11, GroupMessagePushRequest.getDefaultInstance()),
    
    /**
     * 群消息推送返回
     */
    GROUP_MESSAGE_PUSH_RESPONSE(12, GroupMessagePushResponse.getDefaultInstance())
    ;
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageTypeManager.class);
    
    
    /**
     * 消息的类型枚举
     */
    private final int messageType;
    
    /**
     * 消息对应的具体类型(由protocol生成)
     */
    private final MessageLite bodyType;
    
    MessageTypeManager(int messageType, MessageLite bodyType) {
        this.messageType = messageType;
        this.bodyType = bodyType;
    }
    
    public int getMessageType() {
        return messageType;
    }
    
    public MessageLite getBodyType() {
        return bodyType;
    }
    
    
    public static MessageLite getBodyTypeByMsgType(int messageType) {
        for (MessageTypeManager value : MessageTypeManager.values()) {
            if (value.messageType == messageType) {
                return value.bodyType;
            }
        }
        LOGGER.error("error cmd: {}", messageType);
        throw new RuntimeException("error msgType:" + messageType);
    }
    
    
    public static int getMessageTypeTypeByBodyType(MessageLite messageLite) {
        for (MessageTypeManager value : MessageTypeManager.values()) {
            if (value.bodyType.getClass() == messageLite.getClass()) {
                return value.messageType;
            }
        }
        LOGGER.error("error msgType: {}", messageLite.getClass().getName());
        throw new RuntimeException("error msgType: " + messageLite.getClass().getName());
    }
}
