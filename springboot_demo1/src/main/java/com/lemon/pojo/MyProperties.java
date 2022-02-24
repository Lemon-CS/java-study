package com.lemon.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 1:43 下午
 */
@Component
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")   //配置自定义配置文件的名称及位置
public class MyProperties {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "MyProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
