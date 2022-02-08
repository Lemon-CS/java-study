package com.fangpeng.design.pattern.command;

/**
 * 厨师类
 * @author 方鹏
 * @date 2022年02月08日 4:04 下午
 */
public class SeniorChef {

    public void makeFood(String name,int num) {
        System.out.println("厨师制作：" + num + "份" + name);
    }

}
