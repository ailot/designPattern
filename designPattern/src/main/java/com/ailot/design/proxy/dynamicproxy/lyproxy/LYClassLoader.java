/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.lyproxy;

import java.io.*;

/**
 * @author ailot
 * @version LYClassLoader.java, 2019年03月21日 下午9:06
 */
public class LYClassLoader extends ClassLoader {

    private File classPathFile;
    public LYClassLoader(){
        String classPath = LYClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = LYClassLoader.class.getPackage().getName()+ "."+ name;
        if (classPathFile!=null){
            File classFile = new File(classPathFile,name.replaceAll("\\.","/")+".class");
            if (classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer))!=-1 ){
                        out.write(buffer,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }
}
