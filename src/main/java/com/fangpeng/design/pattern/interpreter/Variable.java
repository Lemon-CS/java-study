package com.fangpeng.design.pattern.interpreter;

/**
 * 封装变量的类
 * @author 方鹏
 * @date 2022年02月09日 9:27 下午
 */
public class Variable extends AbstractExpression {

    //声明存储变量名的成员变量
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        //直接返回变量的值
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
