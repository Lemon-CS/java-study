package com.fangpeng.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类，将该类设计为单例
 * @author 方鹏
 * @date 2022年02月08日 2:39 下午
 */
public class BoxFactory {

    private Map<String, AbstractBox> map;

    //在构造方法中进行初始化操作
    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    private static BoxFactory factory = new BoxFactory();

    //提供一个方法获取该工厂类对象
    public static BoxFactory getInstance() {
        return factory;
    }

    //根据名称获取图形对象
    public AbstractBox getShape(String name) {
        return map.get(name);
    }

}
