### spring boot 与 mybatis 简单整合

- 添加依赖
    ```xml
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.driver.version}</version>
        </dependency>
            
    
        <!-- 添加mybatis插件简化开发-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.1.0</version>
        </dependency>
    ```

- 添加配置
    ```yml
    server:
      port: 8081
    
    spring:
      datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://192.168.100.230/sboot?useUnicode=true&characterEncoding=utf-8
        username: root
        password: 123456
    
    #mybatis配置
    mybatis-plus:
      #Mapper映射文件位置
      mapper-locations: classpath*:mapper/*.xml
      #实体扫描，多个package用逗号或者分号分隔
      type-aliases-package: org.chp.sboot.mybatis.domain
      global-config:
        db-config:
          #主键类型
          id-type: auto
          #字段策略
          field-strategy: not_empty
    ```
- 新建实体类、Mapper接口和Mapper映射文件

    - 实体类
    ```java
    package org.chp.sboot.mybatis.domain;
    
    import lombok.Data;
    
    import java.io.Serializable;
    import java.util.Date;
    
    /**
     * @author jeff
     * <p>Date: 2019-11-06 14:54:00</p>
     */
    @Data
    public class User implements Serializable {
    
        private Integer id;
    
        private String username;
    
        private String password;
    
        private Integer age;
    
        private String email;
    
        private String phone;
    
        private Date createDate;
    
        private Date updateDate;
    }
    
    ```
    
    - Mapper接口
    ```java
    package org.chp.sboot.mybatis.mapper;
    
    import com.baomidou.mybatisplus.core.mapper.BaseMapper;
    import org.apache.ibatis.annotations.Mapper;
    import org.chp.sboot.mybatis.domain.User;
    
    /**
     *  继承 BaseMapper<>可实现简单的CRUD功能
     *  复杂功能需要自定义的Mapper映射文件
     * @author jeff
     * <p>Date: 2019-11-06 18:30:00</p>
     */
    @Mapper
    public interface UserMapper extends BaseMapper<User> {
    
        User findById(Integer id);
    }
  
    ```
    
    - Mapper映射文件：resources/mapper
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
    <mapper namespace="org.chp.sboot.mybatis.mapper.UserMapper">
        <resultMap id="User" type="org.chp.sboot.mybatis.domain.User">
            <result property="id"  column="id"/>
            <result property="username"  column="username"/>
            <result property="password"  column="password"/>
            <result property="age"  column="age"/>
            <result property="email"  column="email"/>
            <result property="phone"  column="phone"/>
            <result property="createDate"  column="create_date"/>
            <result property="updateDate"  column="update_date"/>
        </resultMap>
    
        <sql id="userColumns">
            id, username, password, age, email, phone, create_date, update_date
        </sql>
        
        <select id="findById" resultMap="User" parameterType="Integer">
            select
            <include refid="userColumns"/>
            from user
            where id = #{id}
        </select>
    </mapper>

    ```
    