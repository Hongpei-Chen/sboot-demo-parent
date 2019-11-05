package org.chp.sboot.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author jeff
 * <p>Date: 2019-11-04 22:47:00</p>
 */
@Data
@ApiModel(value = "product对象", description = "产品说明")
public class ProductVo {

    @ApiModelProperty(value = "产品id(更新时必填)", example = "12asdas3434vsf")
    private String id;

    @ApiModelProperty(value = "产品名称", required = true, example = "华为P30")
    @NotBlank(message = "产品名称不能为空")
    private String productName;

    @ApiModelProperty(value = "产品价格", required = true, example = "300")
    @NotNull(message = "价格不能为空")
    private Integer price;

    private String description;

}
