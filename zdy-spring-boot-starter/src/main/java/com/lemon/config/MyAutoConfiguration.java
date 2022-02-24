package com.lemon.config;

import com.lemon.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 4:26 下午
 */
@Configuration
@ConditionalOnClass  // 当类路径下有指定的类才会进行自动配置
public class MyAutoConfiguration {

    static {
        System.out.println("MyAutoConfiguration init....");
    }

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

}
