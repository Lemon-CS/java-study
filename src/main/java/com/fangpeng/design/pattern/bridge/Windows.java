package com.fangpeng.design.pattern.bridge;

/**
 * 扩展抽象化角色(windows操作系统)
 * @author 方鹏
 * @date 2022年02月08日 1:30 下午
 */
public class Windows extends OpratingSystem {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
