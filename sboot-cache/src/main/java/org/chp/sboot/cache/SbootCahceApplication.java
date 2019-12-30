package org.chp.sboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author jeff
 * <p>Date: 2019-11-12 22:00:00</p>
 */
@SpringBootApplication
@EnableCaching          //开始缓存
public class SbootCahceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootCahceApplication.class, args);
    }
}
