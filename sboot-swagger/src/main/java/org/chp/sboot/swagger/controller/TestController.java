package org.chp.sboot.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeff
 * <p>Date: 2019-11-04 22:21:00</p>
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "TEST";
    }
}
