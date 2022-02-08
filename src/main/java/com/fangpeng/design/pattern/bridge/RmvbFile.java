package com.fangpeng.design.pattern.bridge;

/**
 * rmvb视频文件（具体的实现化角色）
 * @author 方鹏
 * @date 2022年02月08日 1:29 下午
 */
public class RmvbFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件 ：" + fileName);
    }
}
