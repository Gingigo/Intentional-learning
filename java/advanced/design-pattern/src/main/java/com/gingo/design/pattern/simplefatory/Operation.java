package com.gingo.design.pattern.simplefatory;

/**
 * 抽象运算类
 */
public abstract class Operation {
    private double numberA = 0;
    private double numberB = 0;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    // 由子类实现 A B 两个数具体的运行规则
    public abstract double getResult() throws Exception;
}
