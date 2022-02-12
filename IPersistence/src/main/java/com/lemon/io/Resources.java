package com.lemon.io;

import java.io.InputStream;

/**
 * @Description: Resources
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 2:04 下午
 */
public class Resources {

    // 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourceAsStream(String path) {
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return inputStream;
    }

}
