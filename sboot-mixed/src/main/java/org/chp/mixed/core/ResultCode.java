package org.chp.mixed.core;

/**
 * @author jeff
 * <p>Date: 2019-11-06 11:17:00</p>
 */
public enum ResultCode {
    SUCCESS(0, "成功"),
    SYS_ERROR(-1, "系统繁忙，请稍后再试"),

    PARAMS_ERROR(1400, "请求参数错误"),
    NOT_LOGIN(1401, "您还未登陆或者登陆已超时，请重新登陆");


    public Integer code;
    public String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
