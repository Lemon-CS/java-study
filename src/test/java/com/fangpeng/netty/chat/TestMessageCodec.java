package com.fangpeng.netty.chat;

import com.fangpeng.netty.chat.message.LoginRequestMessage;
import com.fangpeng.netty.chat.protocol.MessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author 方鹏
 * @date 2022年01月26日 5:36 下午
 */
public class TestMessageCodec {

    public static void main(String[] args) throws Exception {
        EmbeddedChannel channel = new EmbeddedChannel(
                new LoggingHandler(),
                new LengthFieldBasedFrameDecoder(
                        1024, 12, 4, 0, 0),
                new MessageCodec()
        );
        // encode
        LoginRequestMessage message = new LoginRequestMessage("zhangsan", "123", "张三");
//        channel.writeOutbound(message);
        // decode
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        new MessageCodec().encode(null, message, buf);

        ByteBuf s1 = buf.slice(0, 100);
        ByteBuf s2 = buf.slice(100, buf.readableBytes() - 100);
        s1.retain(); // 引用计数 2
        channel.writeInbound(s1); // release 1
        channel.writeInbound(s2);
    }

}
