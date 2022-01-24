package com.yjlan.im.common.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author yjlan
 * @version V1.0
 * @Description RocketMQ的通用发送
 * @date 2022.01.24 15:08
 */
@Component
public class RocketMqProducer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RocketMqProducer.class);
    
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    
    @Value("${rocketmq.producer.send-message-timeout:3000}")
    private Integer messageTimeOut;
    
    private static final String ROCKET_SPLIT = ":";
    
    /**
     * 发送普通消息
     */
    public void sendMsg(String topic, String msgBody) {
        SendResult sendResult = rocketMQTemplate
                .syncSend(topic, MessageBuilder.withPayload(msgBody).build(), messageTimeOut);
        success(topic, "", "", msgBody, sendResult.getMsgId());
    }
    
    /**
     * 发送普通消息
     */
    public void sendMsg(String topic, String msgBody, String msgKey) {
        SendResult sendResult = rocketMQTemplate
                .syncSend(topic, MessageBuilder.withPayload(msgBody).setHeader("KEYS", msgKey).build(), messageTimeOut);
        success(topic, msgKey, "", msgBody, sendResult.getMsgId());
    }
    
    /**
     * 发送异步消息 在SendCallback中可处理相关成功失败时的逻辑
     */
    public void sendAsyncMsg(String topic, String msgBody) {
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // 处理消息发送成功逻辑
                success(topic, "", "", msgBody, sendResult.getMsgId());
            }
            
            @Override
            public void onException(Throwable e) {
                // 出现异常意味着发送失败,为了避免消息丢失,建议缓存该消息然后进行重试。
                error(topic, "", "", msgBody, e);
            }
        });
    }
    
    
    /**
     * 发送异步消息 在SendCallback中可处理相关成功失败时的逻辑
     */
    public void sendAsyncMsg(String topic, String msgBody, String msgKey) {
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).setHeader("KEYS", msgKey).build(),
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        // 处理消息发送成功逻辑
                        success(topic, msgKey, "", msgBody, sendResult.getMsgId());
                    }
                    
                    @Override
                    public void onException(Throwable e) {
                        // 出现异常意味着发送失败,为了避免消息丢失,建议缓存该消息然后进行重试。
                        error(topic, msgKey, "", msgBody, e);
                    }
                });
    }
    
    /**
     * 发送延时消息<br/> 在start版本中 延时消息一共分为18个等级分别为：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h<br/>
     */
    public void sendDelayMsg(String topic, String msgBody, Integer delayLevel) {
        SendResult sendResult = rocketMQTemplate
                .syncSend(topic, MessageBuilder.withPayload(msgBody).build(), delayLevel);
        success(topic, "", "", msgBody, sendResult.getMsgId());
    }
    
    /**
     * 发送带tag的消息,直接在topic后面加上":tag"
     */
    public void sendTagMsg(String topic, String tag, String msgBody) {
        SendResult sendResult = rocketMQTemplate
                .syncSend(topic + ROCKET_SPLIT + tag, MessageBuilder.withPayload(msgBody).build(), messageTimeOut);
        success(topic, "", tag, msgBody, sendResult.getMsgId());
    }
    
    /**
     * 发送带tag的消息,直接在topic后面加上":tag"
     */
    public void sendTagMsg(String topic, String tag, String msgBody, String msgKey) {
        SendResult sendResult = rocketMQTemplate
                .syncSend(topic + ROCKET_SPLIT + tag,
                        MessageBuilder.withPayload(msgBody).setHeader("KEYS", msgKey).build(), messageTimeOut);
        success(topic, msgKey, tag, msgBody, sendResult.getMsgId());
    }
    
    
    private void error(String topic, String msgKey, String tag, String body, Throwable e) {
        LOGGER.error("发送MQ消息失败-- Topic:{}, Key:{}, tag:{}, body:{}"
                , topic, msgKey, tag, body);
        LOGGER.error("errorMsg --- {}", e.getMessage());
    }
    
    private void success(String topic, String msgKey, String tag, String body, String messageId) {
        LOGGER.info("发送MQ消息成功 -- Topic:{} ,msgId:{} , Key:{}, tag:{}, body:{}"
                , topic, messageId, msgKey, tag, body);
    }
}
