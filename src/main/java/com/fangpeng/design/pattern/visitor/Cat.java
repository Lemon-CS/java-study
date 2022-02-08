package com.fangpeng.design.pattern.visitor;

/**
 * 具体元素角色类（宠物猫）
 * @author 方鹏
 * @date 2022年02月08日 10:07 下午
 */
public class Cat implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this); //访问者给宠物猫喂食
        System.out.println("好好吃，喵喵喵。。。");
    }
}
