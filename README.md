### spring boot各种功能的demo和第三方的集成

- sboot-mixed: 大杂烩
- sboot-swagger:    spring boot 和 swagger2的集成
- sboot-data-jpa:   spring data jpa数据库访问
- sboot-mybatis:    spring boot 集成 mybatis
- sboot-mongodb:    spring boot 集成 mongodb
- sboot-redis:      spring boot 集成 redis


#### spring boot 日志配置
- 默认日志输出
    ```
    2019-11-12 21:18:56.189  INFO 101248 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8082 (http) with context path ''
    1. 2019-11-12 21:18:56.189  时间日期 精确到毫秒
    2. INFO                     日志级别，默认 INFO
    3. 101248                   进程ID
    4. ---                      分隔符
    5. [           main]        线程名称
    6. o.s.b.w.embedded.tomcat.TomcatWebServer    类名(通常使用源代码类名)
    7.                          日志具体内容                       
    ```

- 修改日志级别
    ```
    1. 命令行方式修改
        java -jar app.jar --debug
    2. application.yml 配置
        
    ```
- 修改日志输出目标
    ```
    
    ```
- 使用log4j 

- 将日志记录到mongodb



#### 统一异常处理

#### 定时任务

#### 异步调用