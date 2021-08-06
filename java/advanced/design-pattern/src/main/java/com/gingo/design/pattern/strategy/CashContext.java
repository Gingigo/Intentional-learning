package com.gingo.design.pattern.strategy;

import com.gingo.design.pattern.strategy.impl.CashNormal;
import com.gingo.design.pattern.strategy.impl.CashRebate;
import com.gingo.design.pattern.strategy.impl.CashReturn;

/**
 * 装配策略
 * 主要用途是 选择哪个策略
 */
public class CashContext {
    private CashSuper cs;

    //简单工厂
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满 300 返 100":
                cs = new CashReturn(300, 100);
                break;
            case "打八折":
                cs = new CashRebate(0.8);
                break;
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
