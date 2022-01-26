package com.yjlan.im.dispatcher.session;

import com.yjlan.im.common.constants.Constant;
import com.yjlan.im.common.utils.ChannelIdUtils;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 保存和gateway的连接
 * @author yjlan
 */
public class GatewaySessionManager {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GatewaySessionManager.class);
    
    /**
     * 认证通过后，保存对应的连接
     */
    private static final Map<String,SocketChannel> INSTANCE_CODE_CHANNEL_MAP
             = new ConcurrentHashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);
    
    
    public static SocketChannel getHasAuthSocketChannel(String instanceCode) {
        return INSTANCE_CODE_CHANNEL_MAP.get(instanceCode);
    }
    
    public static void put(String instanceCode,SocketChannel socketChannel) {
        INSTANCE_CODE_CHANNEL_MAP.put(instanceCode,socketChannel);
    }
    

    public static void remove(SocketChannel socketChannel) {
        LOGGER.info( "元素个数" + INSTANCE_CODE_CHANNEL_MAP.size());
        INSTANCE_CODE_CHANNEL_MAP.entrySet().stream().filter(entry -> entry.getValue() == socketChannel).forEach(entry -> INSTANCE_CODE_CHANNEL_MAP.remove(entry.getKey()));
        LOGGER.info( "移除后元素个数" + INSTANCE_CODE_CHANNEL_MAP.size());
    
    }

}
