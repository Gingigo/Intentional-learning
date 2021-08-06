package com.gingo.netty.demo11.fp;

import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNettyPromise {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        eventExecutors.execute(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.debug("set success,{}", 10);
                    // 跨线程传递数据
                    promise.setSuccess(10);
                }
        );
        log.debug("start...");
        log.debug("{}", promise.getNow());
        // 阻塞等待获取数据
        log.debug("{}", promise.get());
    }
}
