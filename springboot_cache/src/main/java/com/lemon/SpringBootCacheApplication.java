package com.lemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 9:03 下午
 */
@EnableCaching  // 开启spring boot基于注解的缓存管理支持
@SpringBootApplication
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}
