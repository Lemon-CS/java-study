package com.fangpeng.design.pattern.observer;

/*
 * 抽象主题角色类
 * @author 方鹏
 * @date 2022/2/8 6:26 下午
 */
public interface Subject {

    //添加订阅者（添加观察者对象）
    void attach(Observer observer);

    //删除订阅者
    void detach(Observer observer);

    //通知订阅者更新消息
    void notify(String message);

}
