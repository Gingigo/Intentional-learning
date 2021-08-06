package com.gingo.design.pattern.simplefatory.impl;

import com.gingo.design.pattern.simplefatory.Operation;

/**
 * 除法运算
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() throws Exception {
        if (super.getNumberA() == 0) {
            throw new Exception("除数不能为 0 ！");
        }
        return super.getNumberA() / super.getNumberB();
    }
}
