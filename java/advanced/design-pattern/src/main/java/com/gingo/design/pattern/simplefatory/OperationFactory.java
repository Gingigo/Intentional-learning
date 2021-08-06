package com.gingo.design.pattern.simplefatory;

import com.gingo.design.pattern.simplefatory.impl.OperationAdd;
import com.gingo.design.pattern.simplefatory.impl.OperationDiv;
import com.gingo.design.pattern.simplefatory.impl.OperationMul;
import com.gingo.design.pattern.simplefatory.impl.OperationSub;

public class OperationFactory {
    public static Operation createOperation(char operate) {
        Operation oper = null;
        switch (operate) {
            case '+':
                oper = new OperationAdd();
                break;
            case '-':
                oper = new OperationSub();
                break;
            case '*':
                oper = new OperationMul();
                break;
            case '/':
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}
