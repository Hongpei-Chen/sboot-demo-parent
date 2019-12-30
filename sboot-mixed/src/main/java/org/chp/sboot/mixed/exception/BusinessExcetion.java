package org.chp.sboot.mixed.exception;

import lombok.Data;

/**
 * 业务异常
 * @author jeff
 * <p>Date: 2019-11-06 11:20:00</p>
 */
@Data
public class BusinessExcetion extends RuntimeException {

    private Integer code;
    private String message;

    public BusinessExcetion(Integer code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
