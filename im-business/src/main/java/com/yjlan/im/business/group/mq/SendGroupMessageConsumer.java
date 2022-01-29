package com.yjlan.im.business.group.mq;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.business.c2c.entity.PeerToPeerMsg;
import com.yjlan.im.business.common.RocketMqProducer;
import com.yjlan.im.business.group.entity.GroupMember;
import com.yjlan.im.business.group.entity.SendToGroupMsg;
import com.yjlan.im.business.group.service.GroupService;
import com.yjlan.im.common.constants.RedisPrefixConstant;
import com.yjlan.im.common.entity.StoreMessage;
import com.yjlan.im.common.mq.RocketMqConstant;

/**
 * @author yjlan
 * @version V1.0
 * @Description send_group_message topic的消费者
 * @date 2022.01.24 15:25
 */
@RocketMQMessageListener(
        // topic
        topic = RocketMqConstant.SEND_GROUP_MESSAGE,
        // 消费组
        consumerGroup = RocketMqConstant.SEND_GROUP_MESSAGE_GROUP,
        // tag
        selectorExpression = "*"
)
@Component
public class SendGroupMessageConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendGroupMessageConsumer.class);
    
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private RocketMqProducer rocketMqProducer;
    
    @Resource
    private GroupService groupService;

    @Override
    public void onMessage(MessageExt messageExt) {
        JSONObject jsonObject = JSONObject.parseObject(new String(messageExt.getBody()));
        LOGGER.info("get send push message,message:{}",jsonObject.toJSONString());
        Long groupId = jsonObject.getLong("groupId");
        Long senderId = jsonObject.getLong("senderId");
        Long timeStamp = jsonObject.getLong("timeStamp");
        String sendContent = jsonObject.getString("sendContent");
        Date queryDate = new Date(timeStamp);
        List<GroupMember> list = groupService.listGroupMember(groupId, queryDate);
        if (CollectionUtils.isEmpty(list)) {
            // 如果消息为空，还是需要记录发过的消息记录
            LOGGER.info("groupId:{},群成员为空,不发送消息",groupId);
            return;
        }
        StoreMessage message = new StoreMessage();
        for (GroupMember groupMember : list) {
            // 过滤掉自己
            if (groupMember.getUserId().equals(senderId)) {
                continue;
            }
            // 对于每一个群成员生成一个群消息
            String key = RedisPrefixConstant.GROUP_MESSAGE + groupMember.getUserId()
                    + "-" + groupMember.getGroupId();
            message.setSendContent(sendContent);
            message.setTimeStamp(timeStamp);
            redisTemplate.opsForZSet().add(key,JSONObject.toJSONString(message),Double.valueOf(timeStamp));
            jsonObject.put("receiverId",groupMember.getUserId());
            rocketMqProducer.sendMsg(RocketMqConstant.PUSH_GROUP_MESSAGE,jsonObject.toJSONString());
        }
        // todo 推送历史消息 or 直接同步进行存储
    }
}
