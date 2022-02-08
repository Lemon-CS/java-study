package com.fangpeng.design.pattern.flyweight;

/**
 * L图形类(具体享元角色)
 * @author 方鹏
 * @date 2022年02月08日 2:38 下午
 */
public class LBox extends AbstractBox {

    @Override
    public String getShape() {
        return "L";
    }
}
