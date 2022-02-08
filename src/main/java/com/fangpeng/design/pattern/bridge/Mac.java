package com.fangpeng.design.pattern.bridge;

/**
 * Mac操作系统(扩展抽象化角色)
 * @author 方鹏
 * @date 2022年02月08日 1:32 下午
 */
public class Mac extends OpratingSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
