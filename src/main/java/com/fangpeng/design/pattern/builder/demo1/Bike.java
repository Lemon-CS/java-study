package com.fangpeng.design.pattern.builder.demo1;

/**
 * 产品对象
 * @author 方鹏
 * @date 2022年02月07日 5:23 下午
 */
public class Bike {

    private String frame;//车架

    private String seat;//车座

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}
