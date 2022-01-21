package com.yjlan.im.dispatcher.server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yjlan.im.common.codec.MessageProtocolDecoder;
import com.yjlan.im.common.codec.MessageProtocolEncoder;
import com.yjlan.im.dispatcher.handler.DispatcherHandler;


/**
 * @author yjlan
 * @version V1.0
 * @Description 分发服务Netty监控端口
 * @date 2022.01.20 16:59
 */
@Component
public class DispatcherNettyServer {
    
    private final Logger LOGGER = LoggerFactory.getLogger(DispatcherNettyServer.class);
    
    @Value("${netty.port}")
    private Integer nettyPort;
    
    /**
     * acceptor线程池
     */
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    
    /**
     * processor线程池
     */
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    
    
    @PostConstruct
    public void startServer() {
        try {
            // 服务引导类，集成了所有配置，用来引导程序加载
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            // 责任链模式，增加handler
                            pipeline.addLast(new ProtobufVarint32FrameDecoder());
                            pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                            pipeline.addLast(new MessageProtocolDecoder());
                            pipeline.addLast(new MessageProtocolEncoder());
                            pipeline.addLast(new DispatcherHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(nettyPort).sync();
            if (channelFuture.isSuccess()) {
                LOGGER.info("启动dispatcher netty 服务成功");
            }
        } catch (InterruptedException e) {
            LOGGER.error("启动dispatcher netty 服务失败 ");
        }
    }
    
    
    @PreDestroy
    public void close() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        LOGGER.info("成功关闭dispatcher netty 服务");
    }
    
    
    
    
}
