package com.yjlan.im.message.push.session;

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

    public static SocketChannel getGatewayChannel(String gatewayChannelId) {
        return GATEWAY_CONNECT_CHANNEL.get(gatewayChannelId);
    }

    public static void put(SocketChannel socketChannel) {
        GATEWAY_CONNECT_CHANNEL.put(ChannelIdUtils.getChannelId(socketChannel),socketChannel);
    }


    public static void remove(SocketChannel socketChannel) {
        GATEWAY_CONNECT_CHANNEL.remove(ChannelIdUtils.getChannelId(socketChannel));
    }

}
