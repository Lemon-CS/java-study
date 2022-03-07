package com.lemon.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 自定义处理类
 *               TextWebSocketFrame: websocket数据是帧的形式处理
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 8:52 下午
 */
@Component
@ChannelHandler.Sharable //设置通道共享
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static List<Channel> channelList = new ArrayList<>();

    /**
     * 通道就绪事件
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //当有新的客户端连接的时候, 将通道放入集合
        channelList.add(channel);
        System.out.println("有新的连接.");
    }


    /**
     * 通道未就绪--channel下线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //当有客户端断开连接的时候,就移除对应的通道
        channelList.remove(channel);
    }

    /**
     * 读就绪事件
     *
     * @param ctx
     * @param textWebSocketFrame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String msg = textWebSocketFrame.text();
        System.out.println("msg:" + msg);
        //当前发送消息的通道, 当前发送的客户端连接
        Channel currChannel = ctx.channel();
        for (Channel channel : channelList) {
            //排除自身通道
            if (channel != currChannel) {
                channel.writeAndFlush(new TextWebSocketFrame(msg));
            }
        }
    }


    /**
     * 异常处理事件
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Channel channel = ctx.channel();
        //移除集合
        channelList.remove(channel);
    }
}
