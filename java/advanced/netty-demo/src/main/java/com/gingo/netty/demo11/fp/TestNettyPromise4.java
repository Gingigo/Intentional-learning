package com.gingo.netty.demo11.fp;

import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNettyPromise4 {
    public static void main(String[] args) throws InterruptedException {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        eventExecutors.execute(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RuntimeException e = new RuntimeException("error...");
                    log.debug("set failure, {}", e.toString());
                    promise.setFailure(e);
                }
        );
        log.debug("start...");
        log.debug("{}", promise.getNow());
        promise.await(); // 与 sync 和 get 区别在于，不会抛异常
        log.debug("result {}", (promise.isSuccess() ? promise.getNow() : promise.cause()).toString());

    }

}
