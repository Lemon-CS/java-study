package com.lemon.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Description: 聊天室处理类
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 7:26 下午
 */
public class NettyChatClientHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 通道读取就绪事件
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
