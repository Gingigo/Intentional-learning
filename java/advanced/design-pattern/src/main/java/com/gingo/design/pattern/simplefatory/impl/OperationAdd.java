package com.gingo.design.pattern.simplefatory.impl;

import com.gingo.design.pattern.simplefatory.Operation;

/**
 * 加法运算
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return super.getNumberA() + super.getNumberB();
    }
}
