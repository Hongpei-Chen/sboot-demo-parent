package org.chp.sboot.mixed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author jeff
 * <p>Date: 2019-11-04 19:00:00</p>
 */
@SpringBootApplication
@EnableScheduling   //开始定时任务
@EnableAsync        //开始异步处理
public class MixedApplication {

    public static void main(String[] args) {
        SpringApplication.run(MixedApplication.class, args);
    }
}
