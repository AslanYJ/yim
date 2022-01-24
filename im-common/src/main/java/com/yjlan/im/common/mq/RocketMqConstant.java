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
     * send_message topic的消费组
     */
    public static final String SEND_MESSAGE_GROUP = "send_message_group";


    /**
     * push_message topic的消费组(这个topic应该独立成一个消息推送服务，目前为了简单，合并在请求分发服务)
     */
    public static final String PUSH_MESSAGE_GROUP = "push_message_group";
}
