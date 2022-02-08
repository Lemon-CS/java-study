package com.fangpeng.design.pattern.bridge;

/**
 * 视频文件(实现化角色)
 * @author 方鹏
 * @date 2022年02月08日 1:27 下午
 */
public interface VideoFile {

    //解码功能
    void decode(String fileName);

}
