package com.gingo.design.pattern.decorator;

public class Main {
    public static void main(String[] args) {
        Pancake pancake = new BasePancake();
        Pancake pancakeWithEgg = new EggDecorator(pancake);
        Pancake pancakeWithLettuce = new LettuceDecorator(pancakeWithEgg);
        Pancake pancakeWithEggAndLettuce = new LettuceDecorator(pancakeWithLettuce);

        System.out.println("手抓饼：" + pancakeWithEggAndLettuce.getMsg() + "价格：" + pancakeWithEggAndLettuce.getPrice());
    }
}
