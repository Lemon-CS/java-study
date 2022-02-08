package com.fangpeng.design.pattern.bridge;

/**
 * @author 方鹏
 * @date 2022年02月08日 1:32 下午
 */
public class Client {

    public static void main(String[] args) {
        //创建mac系统对象
        OpratingSystem system = new Mac(new AviFile());
        //使用操作系统播放视频文件
        system.play("战狼3");
    }

}
