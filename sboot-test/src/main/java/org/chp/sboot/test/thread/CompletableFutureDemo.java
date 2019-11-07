package org.chp.sboot.test.thread;

import java.util.concurrent.*;

/**
 * @author jeff
 * <p>Date: 2019-11-05 15:59:00</p>
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Executor executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": 异步任务开始执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Some Result";
        }, executor).thenApplyAsync(result -> {
            System.out.println(Thread.currentThread().getName() + ": 异步任务回调执行");
            return "Processed Result";
        });

//        stringFuture.get();

        System.out.println("主线程执行完毕");

    }



}
