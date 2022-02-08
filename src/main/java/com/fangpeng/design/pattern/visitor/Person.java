package com.fangpeng.design.pattern.visitor;

/*
 * 抽象访问者角色类
 * @author 方鹏
 * @date 2022/2/8 10:06 下午
 */
public interface Person {

    //喂食宠物狗
    void feed(Cat cat);

    //喂食宠物猫
    void feed(Dog dog);

}
