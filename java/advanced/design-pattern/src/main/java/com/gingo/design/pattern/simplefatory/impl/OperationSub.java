package com.gingo.design.pattern.simplefatory.impl;

import com.gingo.design.pattern.simplefatory.Operation;

/**
 * 减法运算
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return super.getNumberA() - super.getNumberB();
    }
}
