package com.fangpeng.io.nio.demo.bytebuffer;

import java.nio.ByteBuffer;

import static com.fangpeng.io.nio.demo.bytebuffer.ByteBufferUtil.debugAll;

/**
 * @author 方鹏
 * @date 2022年01月23日 5:27 下午
 */
public class ByteBufferReadWrite {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61); // 'a'
        debugAll(buffer);
        buffer.put(new byte[]{0x62, 0x63, 0x64}); // b  c  d
        debugAll(buffer);
//        System.out.println(buffer.get());
        buffer.flip();
        System.out.println(buffer.get());
        debugAll(buffer);
        buffer.compact();
        debugAll(buffer);
        buffer.put(new byte[]{0x65, 0x66});
        debugAll(buffer);
    }

}
