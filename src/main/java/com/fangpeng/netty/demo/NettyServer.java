package com.fangpeng.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author 方鹏
 * @date 2022年01月20日 10:59 下午
 */
public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        // 指定连接数据读写逻辑
                        ch.pipeline().addLast(new FirstServerHandler());
                        //ch.pipeline().addLast(new StringDecoder());
                        //ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                        //    @Override
                        //    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                        //        System.out.println(msg);
                        //    }
                        //});
                    }
                });

        bind(serverBootstrap, 8000);

        //serverBootstrap.bind(8000).addListener(new GenericFutureListener<Future<? super Void>>() {
        //    public void operationComplete(Future<? super Void> future) {
        //        if (future.isSuccess()) {
        //            System.out.println("端口绑定成功!");
        //        } else {
        //            System.err.println("端口绑定失败!");
        //        }
        //    }
        //});
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) {
                if (future.isSuccess()) {
                    System.out.println("端口[" + port + "]绑定成功!");
                } else {
                    System.err.println("端口[" + port + "]绑定失败!");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }

    private static class FirstServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf byteBuf = (ByteBuf) msg;

            System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

            // 回复数据到客户端
            System.out.println(new Date() + ": 服务端写出数据");

            ByteBuf out = getByteBuf(ctx);
            ctx.channel().writeAndFlush(out);
        }

        private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
            byte[] bytes = "你好，欢迎来到Lemon-CS".getBytes(StandardCharsets.UTF_8);

            ByteBuf byteBuf = ctx.alloc().buffer();

            byteBuf.writeBytes(bytes);
            return byteBuf;
        }
    }

}
