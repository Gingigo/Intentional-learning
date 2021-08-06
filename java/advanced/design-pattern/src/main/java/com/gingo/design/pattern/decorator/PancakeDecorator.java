package com.gingo.design.pattern.decorator;

/**
 * 装饰器
 * Decorator
 */
public class PancakeDecorator extends Pancake {


    private Pancake pancake;


    public PancakeDecorator(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    protected String getMsg() {
        return pancake.getMsg();
    }

    @Override
    public int getPrice() {
        return pancake.getPrice();
    }

}
