#### spring boot 集成 dubbo(zookeeper版)

- 基于直连方式修改
- 添加zookeeper依赖(服务提供者和消费者)
    
    ```xml
        <!-- 需要排除 slf4j-log4j12 依赖，否则会出现包冲突-->
        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.10</version>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
            </exclusions>            
        </dependency>
    ```

- 服务提供者的配置修改
    ```yml
    server:
      port: 8082
    
    spring:
      application:
        name: sboot-dubbo-provider
      dubbo:
        server: true
        #不使用注册中心，直连方式(测试使用)
        #registry: N/A
        registry: zookeeper://192.168.100.231:2181
    ```
    
- 服务消费者配置修改
    ```yml
    server:
      port: 8084
    
    spring:
      application:
        name: sboot-dubbo-consumer
      dubbo:
        registry: zookeeper://192.168.100.231:2181
    ```
- 注入服务
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
    
        //直连方式服务注入
    //    @Reference(url = "dubbo://127.0.0.1:20880")
    //    private IMessageService messageService;
    
        @Reference
        private IMessageService messageService;
    
        @Test
        public void testMessage(){
            System.out.println(messageService.sendMessage("hello dubbo"));
        }
    }
    ```

