package org.chp.sboot.mixed.controller;

import org.chp.sboot.mixed.core.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeff
 * <p>Date: 2019-11-19 10:59:00</p>
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @PostMapping("user/login")
    public Result<String> login(){

        return Result.ok();
    }
}
