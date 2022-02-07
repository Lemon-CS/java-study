package com.fangpeng.design.pattern.builder.demo2;

/**
 * @author 方鹏
 * @date 2022年02月07日 5:46 下午
 */
public class Client {

    public static void main(String[] args) {
        //创建手机对象   通过构建者对象获取手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainboard("华硕主板")
                .build();

        System.out.println(phone);
    }

}
