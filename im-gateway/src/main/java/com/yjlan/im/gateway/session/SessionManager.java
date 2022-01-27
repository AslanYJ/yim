package com.yjlan.im.gateway.session;

import com.yjlan.im.common.constants.Constant;
import com.yjlan.im.common.utils.ChannelIdUtils;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.StringUtils;

/**
 * 管理session
 * @author yjlan
 */

public class SessionManager {

    /**
     * 保存用户认证通过后的socketChannel
     */
    private static final Map<Long, SocketChannel> USER_SOCKET_CHANNEL_CACHE = new ConcurrentHashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);

    /**
     * 存储channelId到uid的映射
     */
    private static final Map<String,Long> SOCKET_CHANNEL_UID_CACHE = new ConcurrentHashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);


    /**
     * 认证成功后，保存对应的用户信息
     * @param uid uid
     * @param socketChannel 对应的和client端的连接
     */
    public static void put(Long uid,SocketChannel socketChannel) {
        USER_SOCKET_CHANNEL_CACHE.put(uid,socketChannel);
        SOCKET_CHANNEL_UID_CACHE.put(ChannelIdUtils.getChannelId(socketChannel),uid);
    }


    /**
     * 判断是否已经连接过
     * @param uid 用户id
     * @return 是否已经连接过
     */
    public static boolean isConnected(String uid) {
        return USER_SOCKET_CHANNEL_CACHE.containsKey(uid);
    }


    /**
     * 返回对应的socketChannel
     * @param uid uid
     * @return channel
     */
    public static SocketChannel getSocketChannel(Long uid) {
        return USER_SOCKET_CHANNEL_CACHE.get(uid);
    }

    /**
     * 连接断开后移除对应的链接
     * @param socketChannel 连接
     */
    public static void remove(SocketChannel socketChannel) {
        String channelId = ChannelIdUtils.getChannelId(socketChannel);
        if (!StringUtils.isEmpty(channelId)) {
            Long uid = SOCKET_CHANNEL_UID_CACHE.get(channelId);
            SOCKET_CHANNEL_UID_CACHE.remove(channelId);
            if (uid != null) {
                USER_SOCKET_CHANNEL_CACHE.remove(uid);
            }
            
        }
    }




}
