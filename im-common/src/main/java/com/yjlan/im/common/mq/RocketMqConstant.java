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
     * send_message topic的消费组
     */
    public static final String SEND_MESSAGE_GROUP = "send_message_group";
}
