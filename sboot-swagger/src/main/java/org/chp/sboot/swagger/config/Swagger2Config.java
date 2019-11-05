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
