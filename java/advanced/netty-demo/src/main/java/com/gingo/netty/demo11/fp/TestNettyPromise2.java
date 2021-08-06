package com.gingo.netty.demo11.fp;

import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

/**
 * Promise 通过 addListener 获取传递的信息
 */
@Slf4j
public class TestNettyPromise2 {
    public static void main(String[] args) {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        promise.addListener(future -> {
            log.debug("{}", future.getNow());
        });

        eventExecutors.execute(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.debug("set success,{}", 10);
                    promise.setSuccess(10);
                }
        );
        log.debug("start...");

    }
}
