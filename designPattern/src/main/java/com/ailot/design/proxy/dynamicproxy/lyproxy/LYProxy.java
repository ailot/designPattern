/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.lyproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.Tool;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ailot
 * @version lyproxy.java, 2019年03月21日 下午9:06
 */
public class LYProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(LYClassLoader loader, Class<?>[] interfaces, LYInvocationHandler h) throws IllegalArgumentException {


        try {
            //动态生成源代码
            String src = generateSrc(interfaces);
            String fliePath = LYProxy.class.getResource("").getPath();
            File file = new File(fliePath+"$proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = standardFileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,standardFileManager,null,null,null,iterable);
            task.call();
            standardFileManager.close();
            Class proxyClass = loader.findClass("$proxy0");
            Constructor constructor = proxyClass.getConstructor(LYInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {

        StringBuffer sb = new StringBuffer();
        sb.append("package com.ailot.design.proxy.dynamicproxy.lyproxy;"+ ln);
        sb.append("import com.ailot.design.proxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;"+ ln);
        sb.append("public class $proxy0 implements "+ interfaces[0].getName() +"{" + ln);
        sb.append("LYInvocationHandler h;" + ln);
        sb.append("public $proxy0(LYInvocationHandler h) {" + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);

        for (Method method : interfaces[0].getMethods()){
            sb.append("public " + method.getReturnType().getName()+" " + method.getName() +"(){" + ln);
            sb.append("try{"+ln);
            sb.append("Method m = "+interfaces[0].getName() +".class.getMethod(\""+ method.getName()+"\",new Class[]{});" +ln);
            sb.append("this.h.invoke(this,m,null);"+ln);
            sb.append("}catch(Throwable e){}" +ln);
            sb.append("}");
        }
        sb.append("}");

        System.out.println(sb.toString());
        return sb.toString();
    }
}
