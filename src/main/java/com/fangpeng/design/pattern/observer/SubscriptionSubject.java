package com.fangpeng.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色类
 * @author 方鹏
 * @date 2022年02月08日 6:27 下午
 */
public class SubscriptionSubject implements Subject {

    //定义一个集合，用来存储多个观察者对象
    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        //遍历集合
        for (Observer observer : weixinUserList) {
            //调用观察者对象中的update方法
            observer.update(message);
        }
    }
}
