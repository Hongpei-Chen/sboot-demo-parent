package org.chp.sboot.test.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author jeff
 * <p>Date: 2019-11-05 18:30:00</p>
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("wtf");
            }
        };

        // 延迟 1s 打印 wtf 一次
        timer.schedule(task, 1000);
        // 延迟 1s 固定时延每隔 1s 周期打印一次 wtf
        timer.schedule(task, 1000, 1000);
    }
}
