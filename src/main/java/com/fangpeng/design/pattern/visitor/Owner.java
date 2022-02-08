package com.fangpeng.design.pattern.visitor;

/**
 * 具体访问者角色类(自己)
 * @author 方鹏
 * @date 2022年02月08日 10:08 下午
 */
public class Owner implements Person {
    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂食狗");
    }
}
