package com.gingo.design.pattern.strategy;

import org.junit.jupiter.api.Test;

public class TestStrategy {
    @Test
    public void testReturnStrategy() {
        CashContext context = new CashContext("满 300 返 100");
        double result = context.getResult(700);
        assert result == 500.0;
    }
}
