package org.chp.sboot.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jeff
 * <p>Date: 2019-11-18 23:06:00</p>
 */
@WebServlet(urlPatterns = "/sboot/servlet",
    asyncSupported = true)      //支持异步
public class SbootServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        resp.getWriter().println("Hello Web Servlet");

        //异步方式
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
    }
}
