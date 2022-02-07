package com.fangpeng.design.pattern.prototype.demo;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 方鹏
 * @date 2022年02月07日 1:44 下午
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");

        return (Realizetype) super.clone();
    }
}
