package com.gingo.design.pattern.strategy.impl;

import com.gingo.design.pattern.strategy.CashSuper;

/**
 * 返现
 */
public class CashReturn extends CashSuper {
    private double moneyCondition = 0;
    private double moneyReturn = 0;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition) {
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
