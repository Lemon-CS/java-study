package com.fangpeng.design.pattern.observer;

/**
 * 具体的观察者角色类
 * @author 方鹏
 * @date 2022年02月08日 6:29 下午
 */
public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }

}
