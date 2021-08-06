package com.gingo.design.pattern.simplefatory.impl;

import com.gingo.design.pattern.simplefatory.Operation;

/**
 * 乘法运算
 */
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return super.getNumberA() * super.getNumberB();
    }
}
