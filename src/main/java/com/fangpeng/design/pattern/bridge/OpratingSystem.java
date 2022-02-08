package com.fangpeng.design.pattern.bridge;

/**
 * 抽象的操作系统类(抽象化角色)
 * @author 方鹏
 * @date 2022年02月08日 1:29 下午
 */
public abstract class OpratingSystem {

    //声明videFile变量
    protected VideoFile videoFile;

    public OpratingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);

}
