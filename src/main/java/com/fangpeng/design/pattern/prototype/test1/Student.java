package com.fangpeng.design.pattern.prototype.test1;

import java.io.Serializable;

/**
 * @author 方鹏
 * @date 2022年02月07日 1:58 下午
 */
public class Student implements Serializable {

    //学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

