package com.fangpeng.io.nio.demo.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author 方鹏
 * @date 2022年01月23日 5:33 下午
 */
public class ByteBufferAllocate {

    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
        /*
        class java.nio.HeapByteBuffer    - java 堆内存，读写效率较低，受到 GC 的影响
        class java.nio.DirectByteBuffer  - 直接内存，读写效率高（少一次拷贝），不会受 GC 影响，分配的效率低
         */
    }

}
