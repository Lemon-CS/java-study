package com.lemon.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 1:38 下午
 */
@Component
public class Student {

    @Value("${person.id}")
    private int id;

    @Value("${person.name}")
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
