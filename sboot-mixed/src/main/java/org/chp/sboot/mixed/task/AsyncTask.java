package org.chp.sboot.mixed.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用示例
 * @author jeff
 * <p>Date: 2019-11-12 20:54:00</p>
 */
@Slf4j
@Component
public class AsyncTask {



    /**
     * @Async 所修饰的方法不能定义为static
     * 定义没有返回值的异步调用
     */
    @Async
    public void notReturnTask(){
        log.info("开始没有返回值得异步调用，线程：{}", Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("没有返回值得异步调用完成");
    }

    /**
     * 含有返回值的异步调用
     * @return
     */
    @Async
    public Future<String> dealHaveReturnTask(){
        log.info("开始有返回值得异步调用，线程：{}", Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("有返回值得异步调用完成");
        return new AsyncResult<>("异步回调返回数据");
    }
}
