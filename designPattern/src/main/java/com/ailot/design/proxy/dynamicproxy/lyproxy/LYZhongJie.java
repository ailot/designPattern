/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.lyproxy;

import java.lang.reflect.Method;

import com.ailot.design.proxy.Person;

/**
 * @author ailot
 * @version LYZhongJie.java, 2019年03月21日 下午9:10
 */
public class LYZhongJie implements LYInvocationHandler {
    private Person person;

    public Object getInstance(Person person) {
        this.person = person;
        Class<?> clazz = person.getClass();
        return LYProxy.newProxyInstance(new LYClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.person, args);
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
