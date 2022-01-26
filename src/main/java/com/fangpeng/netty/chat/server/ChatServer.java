package com.fangpeng.netty.chat.server;

import com.fangpeng.netty.chat.message.LoginRequestMessage;
import com.fangpeng.netty.chat.message.LoginResponseMessage;
import com.fangpeng.netty.chat.protocol.MessageCodec;
import com.fangpeng.netty.chat.protocol.MessageCodecSharable;
import com.fangpeng.netty.chat.protocol.ProcotolFrameDecoder;
import com.fangpeng.netty.chat.server.service.UserServiceFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 方鹏
 * @date 2022年01月26日 5:54 下午
 */
@Slf4j
public class ChatServer {

    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker);
            serverBootstrap.channel(NioServerSocketChannel.class);

            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProcotolFrameDecoder());
                    ch.pipeline().addLast(LOGGING_HANDLER);
                    ch.pipeline().addLast(MESSAGE_CODEC);
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<LoginRequestMessage>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage message) throws Exception {
                            String username = message.getUsername();
                            String password = message.getPassword();
                            String nickname = message.getNickname();

                            boolean login = UserServiceFactory.getUserService().login(username, password);
                            LoginResponseMessage responseMessage;
                            if (login) {
                                responseMessage = new LoginResponseMessage(true, "登录成功");
                            } else {
                                responseMessage = new LoginResponseMessage(false, "登录失败");
                            }
                            ctx.writeAndFlush(responseMessage);
                        }
                    });
                }
            });

            ChannelFuture future = serverBootstrap.bind(8080).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

}
