/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.lyproxy;

import java.lang.reflect.Method;

/**
 * @author ailot
 * @version LYInvocationHandler.java, 2019年03月21日 下午9:06
 */
public interface LYInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
