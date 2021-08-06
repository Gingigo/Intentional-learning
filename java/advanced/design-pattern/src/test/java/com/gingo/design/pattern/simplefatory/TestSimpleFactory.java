package com.gingo.design.pattern.simplefatory;

import org.junit.jupiter.api.Test;

public class TestSimpleFactory {
    @Test
    public void testOperationAdd() throws Exception {
        Operation oper;
        oper = OperationFactory.createOperation('+');
        oper.setNumberA(520);
        oper.setNumberB(1314);
        assert oper.getResult() == 1834.0;
    }
}
