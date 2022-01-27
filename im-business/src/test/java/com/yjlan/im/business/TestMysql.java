package com.yjlan.im.business;

import com.yjlan.im.business.c2c.entity.PeerToPeerMsg;
import com.yjlan.im.business.c2c.mapper.PeerToPeerMsgMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = BusinessApplication.class)
@RunWith(SpringRunner.class)
public class TestMysql {
    
    @Resource
    private PeerToPeerMsgMapper peerToPeerMsgMapper;
    
    @Test
    public void testPeer() {
        PeerToPeerMsg peerToPeerMsg = new PeerToPeerMsg();
        peerToPeerMsg.setSenderId(1L);
        peerToPeerMsg.setReceiverId(2L);
        peerToPeerMsg.setSendContent("test1411");
        peerToPeerMsgMapper.insertSelective(peerToPeerMsg);
    }


}
