package com.gingo.design.pattern.strategy.impl;

import com.gingo.design.pattern.strategy.CashSuper;

/**
 * 正常收费策略
 */
public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
