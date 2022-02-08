package com.fangpeng.design.pattern.bridge;

/**
 * avi视频文件（具体的实现化角色）
 * @author 方鹏
 * @date 2022年02月08日 1:28 下午
 */
public class AviFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件 ：" + fileName);
    }
}
