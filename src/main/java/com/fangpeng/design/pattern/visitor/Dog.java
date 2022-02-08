package com.fangpeng.design.pattern.visitor;

/**
 * 具体元素角色类（宠物狗）
 * @author 方鹏
 * @date 2022年02月08日 10:07 下午
 */
public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this); //访问者给宠物猫喂食
        System.out.println("好好吃，汪汪汪。。。");
    }
}
