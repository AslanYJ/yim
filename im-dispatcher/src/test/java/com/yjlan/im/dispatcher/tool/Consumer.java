package com.yjlan.im.dispatcher.tool;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author yjlan
 * @version V1.0
 * @Description (这里用一句话描述这个类的作用)
 * @date 2022.01.24 09:42
 */
public class Consumer {
    
    public static void main(String[] args) throws InterruptedException, MQClientException {
        
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-message-group");
        
        // Specify name server addresses.
        consumer.setNamesrvAddr("114.132.40.61:9876");
        
        // Subscribe one more more topics to consume.
        consumer.subscribe("test-message", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                    ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        
        //Launch the consumer instance.
        consumer.start();
        
        System.out.printf("Consumer Started.%n");
    }
}