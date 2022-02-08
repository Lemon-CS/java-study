package com.fangpeng.design.pattern.flyweight;

/**
 * O图形类(具体享元角色)
 * @author 方鹏
 * @date 2022年02月08日 2:39 下午
 */
public class OBox extends AbstractBox {

    @Override
    public String getShape() {
        return "O";
    }
}
