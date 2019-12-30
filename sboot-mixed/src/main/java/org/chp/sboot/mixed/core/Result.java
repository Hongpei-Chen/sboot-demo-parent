package org.chp.sboot.mixed.core;

import lombok.Data;

/**
 * @author jeff
 * <p>Date: 2019-11-06 11:30:00</p>
 */
@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public static Result sysError(){
        Result result = new Result();
        result.setCode(ResultCode.SYS_ERROR.code);
        result.setMessage(ResultCode.SYS_ERROR.message);
        return result;
    }

    public static Result paramsError(){
        Result result = new Result();
        result.setCode(ResultCode.PARAMS_ERROR.code);
        result.setMessage(ResultCode.PARAMS_ERROR.message);
        return result;
    }

    public static Result error(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result ok(){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMessage(ResultCode.SUCCESS.message);
        return result;
    }

    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMessage(ResultCode.SUCCESS.message);
        result.setData(data);
        return result;
    }



}
