#### spring boot 与 swagger2 集成

- swagger2介绍
    ```
    #官网
    https://swagger.io/
    ```
- 集成步骤

    - 添加依赖
    ````xml
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>
    ````
    
    - 添加配置
    ```java
    package org.chp.sboot.swagger.config;
    
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import springfox.documentation.builders.ApiInfoBuilder;
    import springfox.documentation.builders.PathSelectors;
    import springfox.documentation.builders.RequestHandlerSelectors;
    import springfox.documentation.service.ApiInfo;
    import springfox.documentation.service.Contact;
    import springfox.documentation.spi.DocumentationType;
    import springfox.documentation.spring.web.plugins.Docket;
    import springfox.documentation.swagger2.annotations.EnableSwagger2;
    
    /**
     * Swagger配置类
     * @author jeff
     * <p>Date: 2019-11-04 22:12:00</p>
     */
    @Configuration
    @EnableSwagger2
    public class Swagger2Config {
    
        /**
         * 整个API的描述信息，即ApiInfo对象包括的信息，这部分信息会在页面上展示
         * 指定生成API文档的包名
         * 指定生成API的路径
         */
        @Bean
        public Docket createRestApi() {
    
            //文档类型
            return new Docket(DocumentationType.SWAGGER_2)
                    //文档描述信息
                    .apiInfo(apiInfo())
                    .select()
                    //扫描的包
                    .apis(RequestHandlerSelectors.basePackage("org.chp.sboot.swagger.controller"))
                    //匹配的路径
                    .paths(PathSelectors.regex("/rest/.*"))
                    .build();
        }
    
    
        /**
         * API 文档的描述性信息
         */
        private ApiInfo apiInfo(){
            return new ApiInfoBuilder()
                    //页面标题
                    .title("测试 Restful 文档")
                    .description("测试 Restful 文档")
                    .termsOfServiceUrl("http://127.0.0.1:8080/")
                    //创建人
                    .contact(new Contact("jeff", "http://127.0.0.1:8080/rest", "1939150405@qq.com"))
                    .version("1.0")
                    .build();
        }
    }

    ```
    
    - 实体和接口添加相应的注解说明
   
- 注解说明

    - @Api：修饰整个类，描述Controller的作用
    - @ApiOperation：描述一个类的一个方法，或者说一个接口
    - @ApiImplicitParams，@ApiImplicitParam的容器，可包含多个@ApiImplicitParam注解
    - @ApiImplicitParam，请求参数属性配置
    - @ApiResponses，@ApiResponse容器，可以包含多个@ApiResponse注解
    - @ApiResponse，返回结果属性配置
        ```java
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

        ```
    
    - @ApiModel是对整个类的属性的配置
    - @ApiModelProperty是对具体每个字段的属性配置
        ```java
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

        ```
     