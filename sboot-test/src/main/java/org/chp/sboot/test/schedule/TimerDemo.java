package org.chp.sboot.test.schedule;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author jeff
 * <p>Date: 2019-11-11 17:58:00</p>
 */
public class TimerDemo {

    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 2000);
    }
}
