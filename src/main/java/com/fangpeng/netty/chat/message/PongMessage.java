package com.fangpeng.netty.chat.message;

/**
 * @author 方鹏
 * @date 2022年01月26日 9:26 下午
 */
public class PongMessage extends Message {
    @Override
    public int getMessageType() {
        return PongMessage;
    }
}
