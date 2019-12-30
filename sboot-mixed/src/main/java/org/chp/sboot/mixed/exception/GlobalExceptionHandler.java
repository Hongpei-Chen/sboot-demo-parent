package org.chp.sboot.mixed.exception;

import lombok.extern.slf4j.Slf4j;
import org.chp.sboot.mixed.core.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * @author jeff
 * <p>Date: 2019-11-06 11:05:00</p>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result globalExcetionHandle(HttpServletRequest request, Exception e){
        log.error("系统异常：{}", e);
        log.error("系统异常请求路径：{}", request.getRequestURL().toString());
        return Result.sysError();
    }

    @ExceptionHandler(BusinessExcetion.class)
    public Result businessExceptionHandle(HttpServletRequest request, BusinessExcetion e){
        log.error("业务异常：{}", e);
        log.error("业务异常请求路径：{}", request.getRequestURL().toString());
        return Result.error(e.getCode(), e.getMessage());
    }
}
