package com.lemon.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: MybatisPlusConfig
 * @Author : Lemon-CS
 * @Date : 2022年02月16日 12:23 上午
 */
@Configuration
public class MybatisPlusConfig {

    /*
        分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
