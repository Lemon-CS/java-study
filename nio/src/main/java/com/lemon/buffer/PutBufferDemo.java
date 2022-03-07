package com.lemon.buffer;

import java.nio.ByteBuffer;

/**
 * @Description: 向缓冲区中添加数据
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 2:14 下午
 */
public class PutBufferDemo {

    public static void main(String[] args) {
        //1.创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());//0 获取当前索引所在位置
        System.out.println(buffer.limit());//10 最多能操作到哪个索引位置
        System.out.println(buffer.capacity());//10 返回缓冲区总长度
        System.out.println(buffer.remaining());//10 还有多少个可以操作的个数

        System.out.println("----------------");
        // 修改当前索引所在位置
        //buffer.position(1);
        // 修改最多能操作到哪个索引的位置
        //buffer.limit(9);
        // System.out.println(buffer.position());//1 获取当前索引所在位置
        //System.out.println(buffer.limit());//9 最多能操作到哪个索引位置
        //System.out.println(buffer.capacity());//10 返回缓冲区总长度
        //System.out.println(buffer.remaining());//8 还有多少个可以操作的个数

        // 添加一个字节
        buffer.put((byte) 97);
        System.out.println(buffer.position());//1 获取当前索引所在位置
        System.out.println(buffer.limit());//10 最多能操作到哪个索引位置
        System.out.println(buffer.capacity());//10 返回缓冲区总长度
        System.out.println(buffer.remaining());//9 还有多少个可以操作的个数

        System.out.println("----------------");
        // 添加一个数组
        buffer.put("abc".getBytes());
        System.out.println(buffer.position());//4 获取当前索引所在位置
        System.out.println(buffer.limit());//10 最多能操作到哪个索引位置
        System.out.println(buffer.capacity());//10 返回缓冲区总长度
        System.out.println(buffer.remaining());//6 还有多少个可以操作的个数
        System.out.println("----------------");
        // 添加一个数组
        buffer.put("123456".getBytes());
        System.out.println(buffer.position());//10 获取当前索引所在位置
        System.out.println(buffer.limit());//10 最多能操作到哪个索引位置
        System.out.println(buffer.capacity());//10 返回缓冲区总长度
        System.out.println(buffer.remaining());//0 还有多少个可以操作的个数
        System.out.println(buffer.hasRemaining());//false 是否还能操作
        System.out.println("----------------");
        //如果缓冲区满了. 可以调整position位置, 就可以重复写. 会覆盖之前存入索引位置的值
        buffer.position(0);
        buffer.put("123456".getBytes());
        System.out.println(buffer.position());//6 获取当前索引所在位置
        System.out.println(buffer.limit());//10 最多能操作到哪个索引位置
        System.out.println(buffer.capacity());//10 返回缓冲区总长度
        System.out.println(buffer.remaining());//4 还有多少个可以操作的个数
        System.out.println(buffer.hasRemaining());//true 是否还能操作

    }

}
