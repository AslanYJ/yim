package com.yjlan.im.dispatcher.tool;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.yjlan.im.common.mq.RocketMqConstant;
import com.yjlan.im.dispatcher.DispatcherApplication;
import com.yjlan.im.dispatcher.mq.RocketMqProducer;

/**
 * 测试Redis
 * @author yjlan
 */
@SpringBootTest(classes = DispatcherApplication.class)
@RunWith(SpringRunner.class)
public class TestRocketMqProducer {

    @Resource
    private RocketMqProducer rocketMqProducer;

    @Test
    public void test() {
        JSONObject object = new JSONObject();
        object.put("userId", 21000077);
        rocketMqProducer.sendMsg(RocketMqConstant.SEND_MESSAGE,object.toJSONString());
    }
}
