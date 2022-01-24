package com.fangpeng.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author 方鹏
 * @date 2022年01月20日 11:03 下午
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        // 指定连接数据读写逻辑
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();

        //while (true) {
        //    channel.writeAndFlush(new Date() + ": hello world!");
        //    Thread.sleep(2000);
        //}
    }

    private static class FirstClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            System.out.println(new Date() + ": 客户端写出数据");

            // 1. 获取数据
            ByteBuf buffer = getByteBuf(ctx);

            // 2. 写数据
            ctx.channel().writeAndFlush(buffer);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf byteBuf = (ByteBuf) msg;

            System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
        }

        private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
            // 1. 获取二进制抽象 ByteBuf
            ByteBuf buffer = ctx.alloc().buffer();

            // 2. 准备数据，指定字符串的字符集为 utf-8
            byte[] bytes = "你好，Lemon!".getBytes(Charset.forName("utf-8"));

            // 3. 填充数据到 ByteBuf
            buffer.writeBytes(bytes);

            return buffer;
        }

    }
}
