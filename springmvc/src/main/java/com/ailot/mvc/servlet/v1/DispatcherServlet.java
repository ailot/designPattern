package com.ailot.mvc.servlet.v1;

import com.ailot.mvc.annotation.Autowired;
import com.ailot.mvc.annotation.Controller;
import com.ailot.mvc.annotation.RequestMapping;
import com.ailot.mvc.annotation.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author ailot
 * @version DispatcherServlet.java, 2019年04月07日 下午2:51
 */
public class DispatcherServlet extends HttpServlet {

    private Properties properties = new Properties();

    private List<String> classNames = Lists.newArrayList();

    private Map<String,Object> ioc = Maps.newHashMap();

    private Map<String,Method> handlerMapping = Maps.newHashMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //6、调用
        try {
            doDistapcher(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void doDistapcher(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"").replaceAll("/+","/");
        if (this.handlerMapping.containsKey(url)){
            Method method = handlerMapping.get(url);
            String beanName = toLowFirstCase(method.getDeclaringClass().getSimpleName());
            Map<String, String[]> parameterMap = req.getParameterMap();
            method.invoke(ioc.get(beanName),new Object[]{req,resp,parameterMap.get("name")[0]});

        }else {
            resp.getWriter().write("404 NOT FOUND");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));


        //2、扫描包
        doScanner(properties.getProperty("scanPackage"));


        //3、初始化扫描到的类，并加入IOC容器中
        doInstance();

        //4、完成依赖注入
        doAutowired();


        //5、初始化handlerMapping
        initHandlerMapping();


        System.out.println("spring mvc is init!");

    }

    private void initHandlerMapping() {

        if (ioc.isEmpty()){return;}
        ioc.forEach((key,value) ->{
            Class<?> clazz = value.getClass();
            String baseUrl = "";
            if (clazz.isAnnotationPresent(Controller.class) && clazz.isAnnotationPresent(RequestMapping.class)){
                RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
                baseUrl = requestMapping.value();
            }
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(RequestMapping.class)){
                    RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
                    String url = ("/" + baseUrl +"/"+ requestMapping.value()).replaceAll("/+","/");
                    handlerMapping.put(url,method);
                    System.out.println("Mapped" + url + "," + method);
                }
            }
        });

    }

    private void doAutowired() {

        if (ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> entry : ioc.entrySet()){

        }

        ioc.forEach((key,value) ->{
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autowired.class)){continue;}
                Autowired autowired = field.getAnnotation(Autowired.class);
                String beanName = autowired.value();
                if ("".equals(beanName.trim())){
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(value,ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void doInstance() {

        if (classNames.isEmpty()){ return;}

        classNames.stream().forEach(item ->{
            try {
                Class<?> clazz = Class.forName(item);
                Object instance = clazz.newInstance();
                if (clazz.isAnnotationPresent(Controller.class)){
                    String beanName = toLowFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,instance);
                }else if (clazz.isAnnotationPresent(Service.class)){
                    //自定义名字
                    Service service = clazz.getAnnotation(Service.class);
                    String beanName = service.value();
                    if ("".equals(beanName.trim())){
                        //默认类名
                        beanName = toLowFirstCase(clazz.getSimpleName());
                    }
                    ioc.put(beanName,instance);
                    //根据类型自动赋值
                    for (Class<?> i : clazz.getInterfaces()) {
                        if (ioc.containsKey(i.getName())){
                            throw new Exception("The " + i.getName() + " is existed!");
                        }
                        ioc.put(i.getName(),instance);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    private void doScanner(String scanPackage) {

        URL url = this.getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file :classPath.listFiles()) {
            if (file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
            }else {
                if (!file.getName().endsWith(".class")){continue;}
                String className = scanPackage + "." + file.getName().replaceAll(".class","");
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String toLowFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
