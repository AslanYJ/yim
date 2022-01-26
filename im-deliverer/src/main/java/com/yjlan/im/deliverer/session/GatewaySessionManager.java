package com.yjlan.im.deliverer.session;

import com.yjlan.im.common.constants.Constant;
import com.yjlan.im.common.utils.ChannelIdUtils;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 保存和gateway的连接
 * @author yjlan
 */
public class GatewaySessionManager {

    /**
     * 保存和gateway的channel的连接
     */
    private static final Map<String, SocketChannel> GATEWAY_CONNECT_CHANNEL =
            new ConcurrentHashMap<>(Constant.DEFAULT_HASH_MAP_SIZE);

    public static SocketChannel getGatewayChannel(String instanceCode) {
        return GATEWAY_CONNECT_CHANNEL.get(instanceCode);
    }

    public static void put(String instanceCode,SocketChannel socketChannel) {
        GATEWAY_CONNECT_CHANNEL.put(instanceCode,socketChannel);
    }


    public static void remove(SocketChannel socketChannel) {
        GATEWAY_CONNECT_CHANNEL.entrySet().stream().filter(entry -> entry.getValue() == socketChannel).forEach(entry -> GATEWAY_CONNECT_CHANNEL.remove(entry.getKey()));
    
    }

}
