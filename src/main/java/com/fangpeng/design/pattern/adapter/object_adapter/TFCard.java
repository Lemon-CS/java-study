package com.fangpeng.design.pattern.adapter.object_adapter;

/*
 * 适配者类的接口
 * @author 方鹏
 * @date 2022/2/7 8:44 下午
 */
public interface TFCard {

    //从TF卡中读取数据
    String readTF();
    //往TF卡中写数据
    void writeTF(String msg);

}
