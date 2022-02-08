package com.fangpeng.design.pattern.mediator;

/**
 * 抽象同事类
 * @author 方鹏
 * @date 2022年02月08日 8:28 下午
 */
public abstract class Person {

    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
