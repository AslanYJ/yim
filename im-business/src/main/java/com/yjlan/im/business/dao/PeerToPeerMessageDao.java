package com.yjlan.im.business.dao;

import com.yjlan.im.business.entity.PeerToPeerMsg;
import com.yjlan.im.business.mapper.PeerToPeerMsgMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yjlan
 * @version V1.0
 * @Description 点对点通信DAO层
 * @date 2022.01.24 16:40
 */
@Repository
public class PeerToPeerMessageDao {

    private static final Byte HAS_READ = 1;

    @Resource
    private PeerToPeerMsgMapper peerToPeerMsgMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(PeerToPeerMsg peerToPeerMsg) {
        peerToPeerMsgMapper.insertSelective(peerToPeerMsg);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateByMessageId(Long messageId) {
        PeerToPeerMsg peerToPeerMsg = peerToPeerMsgMapper.selectByPrimaryKey(messageId);
        if (peerToPeerMsg != null) {
            peerToPeerMsg.setIsReaded(HAS_READ);
            peerToPeerMsgMapper.updateByPrimaryKeySelective(peerToPeerMsg);
        }
    }
}
