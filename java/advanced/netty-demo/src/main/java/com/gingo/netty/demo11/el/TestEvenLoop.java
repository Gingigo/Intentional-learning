package com.gingo.netty.demo11.el;

import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutor;

public class TestEvenLoop {
    public static void main(String[] args) {
        DefaultEventExecutorGroup group = new DefaultEventExecutorGroup(2);
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());
        for (EventExecutor executor : group) {
            System.out.println(executor);
        }
    }
}
