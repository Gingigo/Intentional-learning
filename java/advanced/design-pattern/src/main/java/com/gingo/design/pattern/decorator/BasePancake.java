package com.gingo.design.pattern.decorator;

/**
 * 基础套餐
 * ConcreteComponent
 */
public class BasePancake extends Pancake {

    @Override
    protected String getMsg() {
        return "标配手抓饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }

}