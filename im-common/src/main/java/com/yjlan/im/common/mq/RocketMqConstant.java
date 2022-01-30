package com.yjlan.im.common.mq;

/**
 * @author yjlan
 * @version V1.0
 * @Description 涉及到的所有topic集中管理
 * @date 2022.01.24 15:41
 */
public class RocketMqConstant {
    
    /**
     * 发送消息请求的topic
     */
    public static final String SEND_MESSAGE = "send_message";

    /**
     * 推送消息的topic
     */
    public static final String PUSH_MESSAGE  = "push_message";
    
    /**
     * 推送消息的响应
     */
    public static final String PUSH_MESSAGE_RESPONSE = "push_message_response";
    
    /**
     * 发送消息的response
     */
    public static final String SEND_MESSAGE_RESPONSE = "send_message_response";
    
    /**
     * 推送群消息
     */
    public static final String PUSH_GROUP_MESSAGE = "push_group_message";
    
    
    public static final String PUSH_GROUP_MESSAGE_RESPONSE = "push_group_message_response";
    
    
    /**
     * 发送群聊信息请求
     */
    public static final String SEND_GROUP_MESSAGE = "send_group_message";

    /**
     * 发送群聊消息请求响应
     */
    public static final String SEND_GROUP_MESSAGE_RESPONSE = "send_group_message_response";
    
    // =============== 消费组定义=========================================
    
    /**
     * send_message topic的消费组
     */
    public static final String SEND_MESSAGE_GROUP = "send_message_group";
    
    
    public static final String PUSH_MESSAGE_GROUP = "push_message_group";
    
    
    public static final String PUSH_MESSAGE_RESPONSE_GROUP = "push_message_response_group";
    
    
    public static final String SEND_MESSAGE_RESPONSE_GROUP = "send_message_response_group";
    
    
    public static final String SEND_GROUP_MESSAGE_GROUP = "send_group_message_group";
    
    
    public static final String PUSH_GROUP_MESSAGE_GROUP = "push_group_message_group";
    
    public static final String PUSH_GROUP_MESSAGE_RESPONSE_GROUP = "push_group_message_response_group";


    public static final String SEND_GROUP_MESSAGE_RESPONSE_GROUP = "send_group_message_response_group";
}
