package com.fangpeng.netty.chat.protocol;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author 方鹏
 * @date 2022年01月26日 6:19 下午
 */
public class ProcotolFrameDecoder extends LengthFieldBasedFrameDecoder {

    public ProcotolFrameDecoder() {
        this(1024, 12, 4, 0, 0);
    }

    public ProcotolFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

}
