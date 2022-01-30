package com.fangpeng.design.pattern.singleton.demo3;

import com.fangpeng.design.pattern.singleton.demo2.Singleton;

public class Client {

    public static void main(String[] args) {
        com.fangpeng.design.pattern.singleton.demo2.Singleton instance = com.fangpeng.design.pattern.singleton.demo2.Singleton.getInstance();

        com.fangpeng.design.pattern.singleton.demo2.Singleton instance1 = Singleton.getInstance();

        //判断两次获取到的Singleton对象是否是同一个对象
        System.out.println(instance == instance1);
    }

}
