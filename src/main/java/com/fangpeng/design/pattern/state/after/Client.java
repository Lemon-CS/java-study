package com.fangpeng.design.pattern.state.after;

/**
 * @author 方鹏
 * @date 2022年02月08日 6:12 下午
 */
public class Client {

    public static void main(String[] args) {
        //创建环境角色对象
        Context context = new Context();
        //设置当前电梯装填
        context.setLiftState(new ClosingState());

        context.open();
        context.run();
        context.close();
        context.stop();
    }

}
