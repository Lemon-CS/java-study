package com.fangpeng.design.pattern.visitor;

/**
 * 具体访问者角色类(其他人)
 * @author 方鹏
 * @date 2022年02月08日 10:09 下午
 */
public class Someone implements Person {

    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂食狗");
    }
}
