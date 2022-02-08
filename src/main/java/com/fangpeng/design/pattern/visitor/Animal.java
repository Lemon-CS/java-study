package com.fangpeng.design.pattern.visitor;


/**
 * 抽象元素角色类
 * @author 方鹏
 * @date 2022年02月08日 10:05 下午
 */
public interface Animal {

    //接受访问者访问的功能
    void accept(Person person);

}
