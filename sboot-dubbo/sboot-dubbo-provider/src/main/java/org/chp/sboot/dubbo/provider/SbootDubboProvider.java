package org.chp.sboot.dubbo.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jeff
 * <p>Date: 2019-11-14 17:33:00</p>
 */
@SpringBootApplication
@EnableDubboConfiguration
public class SbootDubboProvider {

    public static void main(String[] args) {
        SpringApplication.run(SbootDubboProvider.class, args);
    }
}
