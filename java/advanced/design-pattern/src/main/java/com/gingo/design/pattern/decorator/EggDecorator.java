package com.gingo.design.pattern.decorator;

public class EggDecorator extends PancakeDecorator {

    public EggDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }

}
