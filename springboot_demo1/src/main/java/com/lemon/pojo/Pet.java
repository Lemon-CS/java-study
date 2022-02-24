package com.lemon.pojo;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 1:14 下午
 */
public class Pet {

    private String type; //类型
    private String name; //名字

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
