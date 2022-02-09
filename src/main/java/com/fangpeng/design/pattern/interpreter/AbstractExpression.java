package com.fangpeng.design.pattern.interpreter;

/**
 * 抽象表达式类
 * @author 方鹏
 * @date 2022年02月09日 6:49 下午
 */
public abstract class AbstractExpression {

    public abstract int interpret(Context context);
}
