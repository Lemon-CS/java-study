package com.lemon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年03月07日 8:38 下午
 */
@Component
@ConfigurationProperties(prefix = "netty")
@Data
public class NettyConfig {

    private int port;//netty监听的端口

    private String path;//websocket访问路径

}
