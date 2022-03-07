package com.lemon.buffer;

import java.nio.ByteBuffer;

/**
 * @Description: Buffer的创建
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 2:12 下午
 */
public class CreateBufferDemo {

    public static void main(String[] args) {
        //1.创建指定长度的缓冲区  ByteBuffer为例
        ByteBuffer allocate = ByteBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(allocate.get());//从缓冲区当中拿去数据
        }
        System.out.println("=============================");
        //会报错. 后续讲解
        //System.out.println(allocate.get());//从缓冲区当中拿去数据

        //2.创建一个有内容的缓冲区
        ByteBuffer wrap = ByteBuffer.wrap("lagou".getBytes());
        for (int i = 0; i < 5; i++) {
            System.out.println(wrap.get());
        }
    }

}
