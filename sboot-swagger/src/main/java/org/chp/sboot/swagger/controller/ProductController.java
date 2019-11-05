package org.chp.sboot.swagger.controller;

import io.swagger.annotations.*;
import org.chp.sboot.swagger.support.ResultCode;
import org.chp.sboot.swagger.vo.ProductVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jeff
 * <p>Date: 2019-11-04 22:20:00</p>
 */
@RestController
@RequestMapping("/rest/product")
public class ProductController {

    private static Map<String, ProductVo> productMap = new HashMap<>();


    @GetMapping("/{id}")
    @ApiOperation(value = "产品详情", notes = "根据id查询产品详情", tags = "ProductVo", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "String")
    })
    public ResultCode<ProductVo> find(@PathVariable String id){
        ProductVo product = productMap.get(id);
        if (Objects.isNull(product)){
            return new ResultCode<>(404, "无产品详情数据");
        }

        return new ResultCode<>(product);
    }

    @PostMapping("/save")
    @ApiOperation(value = "添加产品", notes = "添加新产品", tags = "ProductVo", httpMethod = "POST")
    public ResultCode save(@Valid ProductVo product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResultCode(404, bindingResult.getFieldError().getDefaultMessage());
        }
        int size = productMap.size();

        productMap.put(String.valueOf(size++), product);

        return new ResultCode(200, "保存成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除产品", notes = "根据id删除产品", tags = "ProductVo", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=ResultCode.class),
    })
    public ResultCode delete(@PathVariable String id) {
        if (productMap.size() > 0){
            productMap.remove(id);
        }

        return new ResultCode(200, "删除成功");
    }

}
