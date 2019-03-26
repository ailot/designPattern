/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.cglibproxy;

import com.ailot.design.proxy.staticproxy.dbroute.DynamicDataSourceEntity;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author ailot
 * @version CGLibZhongjie.java, 2019年03月24日 下午9:54
 */
public class CGLibZhongjie implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();

        Object object = methodProxy.invokeSuper(o,objects);

        after();


        return object;
    }

    private void after() {
        System.out.println("中介完了");
    }

    private void before() {

        System.out.println("我是中介");

    }

    public Object getInstace(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
