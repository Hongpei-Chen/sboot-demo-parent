package org.chp.sboot.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 的配置
 * @author jeff
 * <p>Date: 2020-01-03 15:18:00</p>
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页配置，需指定数据库类型，否则无法进行分页查询
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
