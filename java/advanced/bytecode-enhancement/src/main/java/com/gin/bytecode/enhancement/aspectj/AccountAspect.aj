package com.gin.bytecode.enhancement.aspectj;

/**
 * 账户 切面（Aspect）
 */
public aspect AccountAspect {
    final int MIN_BALANCE = 10;

    // 切点，用户是筛选合适的接入点（方法）
    pointcut callWithDraw(int amount, Account acc) :
            call(boolean Account.withdraw(int)) && args(amount) && target(acc);

    // 通知(Advice)
    before(int amount, Account acc) : callWithDraw(amount, acc) {
        System.out.println("before advice ...");
    }

    boolean around(int amount, Account acc) :
            callWithDraw(amount, acc) {
        System.out.println("around advice start");
        try {
            return proceed(amount, acc);
        }finally {
            System.out.println("around advice end");
        }

    }

    after(int amount, Account balance) : callWithDraw(amount, balance) {
        System.out.println("after advice ...");
    }
}