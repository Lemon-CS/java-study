package com.fangpeng.design.pattern.state.before;

/**
 * @author 方鹏
 * @date 2022年02月08日 5:25 下午
 */
public class Client {

    public static void main(String[] args) {
        //创建电梯对象
        Lift lift = new Lift();

        //设置当前电梯的状态
        lift.setState(ILift.CLOSING_STATE);

        //打开
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }

}
