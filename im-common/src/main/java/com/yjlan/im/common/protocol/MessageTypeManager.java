package com.yjlan.im.common.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.MessageLite;
import com.yjlan.im.common.proto.AuthenticateRequest;
import com.yjlan.im.common.proto.AuthenticateResponse;

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
    AUTHENTICATE_RESPONSE(2, AuthenticateResponse.getDefaultInstance())
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
