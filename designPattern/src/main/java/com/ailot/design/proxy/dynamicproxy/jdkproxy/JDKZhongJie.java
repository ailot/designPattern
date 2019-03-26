/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.jdkproxy;

import com.ailot.design.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ailot
 * @version ZhongJie.java, 2019年03月21日 下午8:42
 */
public class JDKZhongJie implements InvocationHandler {

    private Person person;

    public Object getInstance(Person person){
        this.person = person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.person,args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("成了收中介费");
    }

    private void before() {
        System.out.println("中介物色");
    }
}
