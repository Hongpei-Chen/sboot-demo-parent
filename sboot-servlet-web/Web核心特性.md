### 传统 Servlet应用

- 依赖
    ```xml
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
         </dependency>   
    ```
- Servlet组件

    - Servlet
        ````
          1. 实现
            @WebServlet
            HttpServlet
            注册
          2. URL映射
             @WebServlet(urlPatterns = "/sboot/servlet")
          3. 注册 
            @ServletComponentScan(basePackages = "org.chp.sboot.web.servlet") 
        ````
    - Filter
    
        ````
          1. 实现
          2. URL映射
          3. 注册  
        ````    
    - Listener
    
        ````
          1. 实现
          2. URL映射
          3. 注册  
        ````
 
- Servlet 注册

- Servlet 注解
    ```
    @ServletComponentScan
    
    @WebServlet
    
    @WebFilter
    
    @WebListener
    ```
    
### 异步非阻塞的Servlet实现

- 注解添加异步支持
    ```java
    @WebServlet(urlPatterns = "/sboot/servlet", asyncSupported = true)      //支持异步
    ```
- 启用异步方式
    ```java
    //异步方式
   //HttpServletRequest req
   AsyncContext asyncContext = req.startAsync();
   asyncContext.start( () -> {
      try {
          resp.getWriter().println("Hello Web Servlet");
                
          //需要触发完成操作
          asyncContext.complete();
      } catch (IOException e) {
          e.printStackTrace();
      }
    });
    ```