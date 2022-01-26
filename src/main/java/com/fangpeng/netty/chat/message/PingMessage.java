package com.fangpeng.netty.chat.message;

/**
 * @author 方鹏
 * @date 2022年01月26日 9:25 下午
 */
public class PingMessage extends Message {
    @Override
    public int getMessageType() {
        return PingMessage;
    }
}

