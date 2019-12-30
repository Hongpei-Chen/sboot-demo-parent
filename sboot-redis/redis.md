### spring boot 整合 redis

- 依赖
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.61</version>
        </dependency>
      
        <!-- lettuce 需依赖的包-->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
            <version>2.6.2</version>
        </dependency>    
    </dependencies>
    ```
- 配置
    ```java
     package org.chp.sboot.redis.config;
     
     import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
     import org.springframework.context.annotation.Bean;
     import org.springframework.context.annotation.Configuration;
     import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
     import org.springframework.data.redis.core.RedisTemplate;
     import org.springframework.data.redis.serializer.StringRedisSerializer;
     
     /**
      * @author jeff
      * <p>Date: 2019-11-07 15:57:00</p>
      */
     @Configuration
     public class RedisConfig {
     
         /**
          * springboot2.x 使用LettuceConnectionFactory 代替 RedisConnectionFactory
          * 在application.yml配置基本信息后,springboot2.x  RedisAutoConfiguration能够自动装配
          * LettuceConnectionFactory 和 RedisConnectionFactory 及其 RedisTemplate
          * @param redisConnectionFactory
          * @return
          */
         @Bean
         public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory){
             RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
             redisTemplate.setConnectionFactory(redisConnectionFactory);
             //配置序列化方式
             redisTemplate.setKeySerializer(new StringRedisSerializer());
             //使用fastjson 代替 GenericJackson2JsonRedisSerializer
             redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
             redisTemplate.setHashKeySerializer(new StringRedisSerializer());
             redisTemplate.setHashValueSerializer(new GenericFastJsonRedisSerializer());
             return redisTemplate;
         }
     
     }
    ```
- 使用
    ```java
    package org.chp.sboot.redis;
    
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.data.redis.core.RedisTemplate;
    import org.springframework.test.context.junit4.SpringRunner;
    
    /**
     * @author jeff
     * <p>Date: 2019-11-07 16:00:00</p>
     */
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class SbootRedisApplicationTest {
    
        @Autowired
        private RedisTemplate<String, Object> redisTemplate;
    
        @Test
        public void testSet(){
            redisTemplate.opsForValue().set("test", "hello redis");
        }
    }

    ```