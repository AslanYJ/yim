package com.yjlan.im.common.utils;

import io.netty.channel.socket.SocketChannel;

/**
 * 获得id转换工具
 * @author yjlan
 */
public class ChannelIdUtils {

    public static String getChannelId(SocketChannel socketChannel) {
        return socketChannel.remoteAddress().getAddress().getHostAddress()
                + ":" + socketChannel.remoteAddress().getPort();
    }
}
