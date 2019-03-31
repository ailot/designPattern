package com.ailot.design.delegate.mvc;

import com.ailot.design.delegate.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ailot
 * @version DispatcherServlet.java, 2019年03月26日 下午10:25
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doDispaticher(req,resp);

    }

    @Override
    public void init() throws ServletException {
        Class<?> methodController = MemberController.class;
        try {
            handlerMapping.add(new Handler("/web/getMemberId.json",methodController.getMethod("getMemberById",new Class[]{String.class}),methodController.newInstance()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doDispaticher(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h: handlerMapping) {
            if (uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        try {
            Object obj = handler.getMethod().invoke(handler.getController(),req.getParameter("mid"));
            resp.getWriter().write(obj.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private void doDispaticher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        if ("getMemberId".equals(uri)){
            new MemberController().getMemberById();
        }else if ("getOrderId".equals(uri)){
            new OrderController().getOrderById();
        }else {
            resp.getWriter().write("404 NOT FOUND");
        }
    }*/


    class Handler{

        private String url;

        private Method method;

        private Object controller;

        public Handler(String url, Method method, Object controller) {
            this.url = url;
            this.method = method;
            this.controller = controller;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }
}
