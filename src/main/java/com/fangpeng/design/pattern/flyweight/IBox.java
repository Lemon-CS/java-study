package com.fangpeng.design.pattern.flyweight;

/**
 * I图形类(具体享元角色)
 * @author 方鹏
 * @date 2022年02月08日 2:38 下午
 */
public class IBox extends AbstractBox {

    @Override
    public String getShape() {
        return "I";
    }
}

