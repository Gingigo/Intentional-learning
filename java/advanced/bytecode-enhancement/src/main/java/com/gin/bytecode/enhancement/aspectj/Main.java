package com.gin.bytecode.enhancement.aspectj;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.withdraw(5);
        account.withdraw(100);
    }

}
