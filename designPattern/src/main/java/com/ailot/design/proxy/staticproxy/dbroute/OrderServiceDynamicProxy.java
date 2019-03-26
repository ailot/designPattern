/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy.dbroute;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ailot
 * @version OrderServiceStaticProxy.java, 2019年03月20日 下午11:14
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private Object dynamicProxy;

    public Object getInstan(Object dynamicProxy) {
        this.dynamicProxy = dynamicProxy;
        Class<?> clazz = dynamicProxy.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before(args[0]);

        Object object = method.invoke(dynamicProxy,args);

        after();
        
        
        return object;
    }

    private void after() {
        System.out.println("完了");
    }

    private void before(Object obj) throws Exception {

        Long time = (Long) obj.getClass().getMethod("getCreateTime").invoke(obj);
        Integer dbroute = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("动态代理类自动分配到DB_"+dbroute);
        DynamicDataSourceEntity.set(dbroute.toString());

    }
}
