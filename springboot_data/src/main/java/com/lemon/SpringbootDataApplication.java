package com.lemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 8:14 下午
 */
@MapperScan(value = "com.lemon.mapper")
@SpringBootApplication
public class SpringbootDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataApplication.class, args);
    }

}
