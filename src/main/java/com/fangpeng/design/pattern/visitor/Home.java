package com.fangpeng.design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类
 * @author 方鹏
 * @date 2022年02月08日 10:10 下午
 */
public class Home {

    //声明一个集合对象，用来存储元素对象
    private List<Animal> nodeList = new ArrayList<Animal>();

    //添加元素功能
    public void add(Animal animal) {
        nodeList.add(animal);
    }

    public void action(Person person) {
        //遍历集合，获取每一个元素，让访问者访问每一个元素
        for (Animal animal : nodeList) {
            animal.accept(person);
        }
    }
}
