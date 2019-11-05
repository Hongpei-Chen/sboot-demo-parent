package org.chp.sboot.swagger.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jeff
 * <p>Date: 2019-11-04 22:24:00</p>
 */
@Data
@ApiModel(value = "返回对象", description = "返回数据结构")
public class ResultCode<T> {

    @ApiModelProperty(value = "状态码", example = "200")
    private Integer code;

    @ApiModelProperty(value = "提示信息", example = "保存成功")
    private String msg;

    @ApiModelProperty(value = "返回具体对象信息")
    private T data;

    public ResultCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultCode(T data){
        this.code = 200;
        this.data = data;
    }

}
