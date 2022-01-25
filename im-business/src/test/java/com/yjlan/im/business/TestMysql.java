package com.yjlan.im.business;

import com.yjlan.im.business.entity.PeerToPeerMsg;
import com.yjlan.im.business.mapper.PeerToPeerMsgMapper;
import com.yjlan.im.business.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = BusinessApplication.class)
@RunWith(SpringRunner.class)
public class TestMysql {

    @Resource
    private TestMapper testMapper;
    
    @Resource
    private PeerToPeerMsgMapper peerToPeerMsgMapper;

    @Test
    public void test() {
        com.yjlan.im.business.entity.Test test = new com.yjlan.im.business.entity.Test();
        test.setAccount("test2");
        testMapper.insert(test);
    }
    
    @Test
    public void testPeer() {
        PeerToPeerMsg peerToPeerMsg = new PeerToPeerMsg();
        peerToPeerMsg.setSenderId("test01");
        peerToPeerMsg.setReceiverId("test02");
        peerToPeerMsg.setSendContent("test");
        peerToPeerMsgMapper.insertSelective(peerToPeerMsg);
    }


}
