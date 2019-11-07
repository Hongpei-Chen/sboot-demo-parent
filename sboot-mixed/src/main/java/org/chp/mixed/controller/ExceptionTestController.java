package org.chp.mixed.controller;

import org.chp.mixed.core.Result;
import org.chp.mixed.core.ResultCode;
import org.chp.mixed.exception.BusinessExcetion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeff
 * <p>Date: 2019-11-06 11:06:00</p>
 */
@RestController
@RequestMapping("rest/ex")
public class ExceptionTestController {


    @GetMapping("/syserror")
    public Result sysError(){
        int i = 1 / 0;
        return Result.ok();
    }

    @GetMapping("/businesserro")
    public Result businessError(){
        throw new BusinessExcetion(ResultCode.NOT_LOGIN.code, ResultCode.NOT_LOGIN.message);
    }
}
