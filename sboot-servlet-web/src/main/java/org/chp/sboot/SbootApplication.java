package org.chp.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author jeff
 * <p>Date: 2019-11-18 23:04:00</p>
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "org.chp.sboot.web.servlet")
public class SbootApplication {


    public static void main(String[] args) {
        SpringApplication.run(SbootApplication.class, args);
    }
}
