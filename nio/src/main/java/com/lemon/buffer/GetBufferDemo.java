package com.lemon.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Description: 从缓冲区中读取数据
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 2:26 下午
 */
public class GetBufferDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("0123".getBytes());
        System.out.println("position:" + buffer.position());//4
        System.out.println("limit:" + buffer.limit());//10
        System.out.println("capacity:" + buffer.capacity());//10
        System.out.println("remaining:" + buffer.remaining());//6

        //切换读模式
        System.out.println("-------------读取数据--------------");
        buffer.flip();
        System.out.println("position:" + buffer.position());//0
        System.out.println("limit:" + buffer.limit());//4
        System.out.println("capacity:" + buffer.capacity());//10
        System.out.println("remaining:" + buffer.remaining());//4
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.println("读取数据为：" + buffer.get());
        }

        //读取完毕后.继续读取会报错,超过limit值
        //System.out.println(allocate.get());
        //读取指定索引字节
        System.out.println("-------------读取指定索引字节--------------");
        System.out.println("读取指定索引数据为：" + buffer.get(1));

        System.out.println("-------------读取多个字节--------------");
        // 重复读取
        buffer.rewind();
        byte[] bytes = new byte[4];
        buffer.get(bytes);
        System.out.println("读取多个字节数据为：" + new String(bytes));

        // 将缓冲区转化字节数组返回
        System.out.println("-------------将缓冲区转化字节数组返回--------------");
        byte[] array = buffer.array();
        System.out.println("缓冲区转化字节数组数据为：" + new String(array));

        // 切换写模式,覆盖之前索引所在位置的值
        System.out.println("------------写模式--------------");
        buffer.clear();
        buffer.put("abc".getBytes());
        System.out.println("写入数据后：" + new String(buffer.array()));

    }

}
