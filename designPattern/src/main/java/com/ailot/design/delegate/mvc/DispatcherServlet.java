package com.ailot.design.delegate.mvc;

import com.ailot.design.delegate.mvc.controller.MemberController;
import com.ailot.design.delegate.mvc.controller.OrderController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;

/**
 * @author ailot
 * @version DispatcherServlet.java, 2019年03月26日 下午10:25
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doDispaticher(req,resp);

    }

    private void doDispaticher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        if ("getMemberId".equals(uri)){
            new MemberController().getMemberById();
        }else if ("getOrderId".equals(uri)){
            new OrderController().getOrderById();
        }else {
            resp.getWriter().write("404 NOT FOUND");
        }
    }
}
