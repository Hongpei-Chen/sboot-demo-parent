#### spring boot 与 dubbo简单集成

- 模块
    ```
    sboot-dubbo-provider    服务提供者模块
    sboot-dubbo-consumer    服务消费者模块
    sboot-dubbo-facade      接口模块(提供者和消费者所依赖的接口)
    ```

- 添加依赖(提供者和消费者)
    ```xml
    <dependency>
      <groupId>com.alibaba.spring.boot</groupId>
      <artifactId>dubbo-spring-boot-starter</artifactId>
      <version>2.0.0</version>
    </dependency>
    <dependency>
      <groupId>org.chp</groupId>
      <artifactId>sboot-dubbo-facade</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
    ```
    
- 服务提供者
    - 配置
    ```yml
    server:
      port: 8082
    
    spring:
      application:
        name: sboot-dubbo-provider
      dubbo:
        server: true
        registry: N/A
    ```
    
    - 接口实现
    ```java
    package org.chp.sboot.dubbo.provider.service;
    
    import com.alibaba.dubbo.config.annotation.Service;
    import org.chp.sboot.dubbo.facade.IMessageService;
    import org.springframework.stereotype.Component;
    
    /**
     * @author jeff
     * <p>Date: 2019-11-14 17:49:00</p>
     */
    @Service(interfaceClass = IMessageService.class)
    @Component
    public class MessageServiceImpl implements IMessageService {
        @Override
        public String sendMessage(String message) {
            return "sboot-dubbo-provider: " + message;
        }
    }
    ```
    
    - 启动配置
    ```java
    package org.chp.sboot.dubbo.provider;
    
    import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    
    /**
     * @author jeff
     * <p>Date: 2019-11-14 17:33:00</p>
     */
    @SpringBootApplication
    @EnableDubboConfiguration
    public class SbootDubboProvider {
    
        public static void main(String[] args) {
            SpringApplication.run(SbootDubboProvider.class, args);
        }
    }
    ```
    
- 服务消费者

    - 配置
    ```yml
    server:
      port: 8084
    
    spring:
      application:
        name: sboot-dubbo-consumer
    ```
    
    - 启动类配置
    ```java
    package org.chp.sboot.dubbo.consumer;
    
    import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    
    /**
     * @author jeff
     * <p>Date: 2019-11-14 17:33:00</p>
     */
    @SpringBootApplication
    @EnableDubboConfiguration
    public class SbootDubboConsumer {
    
        public static void main(String[] args) {
            SpringApplication.run(SbootDubboConsumer.class, args);
        }
    }
    ```
    
    - 测试服务
    ```java
    package org.chp.sboot.dubbo.consumer;
    
    import com.alibaba.dubbo.config.annotation.Reference;
    import org.chp.sboot.dubbo.facade.IMessageService;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;
    
    /**
     * @author jeff
     * <p>Date: 2019-11-14 18:17:00</p>
     */
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class SbootDubboConsumerTest {
    
        @Reference(url = "dubbo://127.0.0.1:20880")
        private IMessageService messageService;
    
        @Test
        public void testMessage(){
            System.out.println(messageService.sendMessage("hello dubbo"));
        }
    }

    ```