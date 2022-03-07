package com.lemon.netty;

import com.lemon.config.NettyConfig;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @Description: Netty服务器
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 8:39 下午
 */
@Component
public class NettyWebSocketServer implements Runnable {

    @Autowired
    private NettyConfig nettyConfig;

    @Autowired
    private WebSocketChannelInit webSocketChannelInit;

    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    /**
     * 资源关闭--在容器销毁是关闭
     */
    @PreDestroy
    public void close() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    @Override
    public void run() {
        try {
            //1.创建服务端启动助手
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //2.设置线程组
            serverBootstrap.group(bossGroup, workerGroup);
            //3.设置参数
            serverBootstrap.channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(webSocketChannelInit);
            ChannelFuture future = serverBootstrap.bind(nettyConfig.getPort()).sync();
            System.out.println("--Netty服务端启动成功---");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
