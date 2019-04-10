package com.ailot.mvc.action;

import com.ailot.mvc.annotation.Autowired;
import com.ailot.mvc.annotation.Controller;
import com.ailot.mvc.annotation.RequestMapping;
import com.ailot.mvc.annotation.RequestParam;
import com.ailot.mvc.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ailot
 * @version DemoAction.java, 2019年04月07日 下午2:35
 */

@Controller
@RequestMapping("/demo")
public class DemoAction {

    @Autowired
    private IDemoService demoservice;

    @RequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name){
        String result = demoservice.get(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
