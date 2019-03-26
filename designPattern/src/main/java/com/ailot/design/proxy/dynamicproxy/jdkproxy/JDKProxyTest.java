/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.jdkproxy;

import com.ailot.design.proxy.Person;

/**
 * @author ailot
 * @version JDKProxyTest.java, 2019年03月21日 下午8:47
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        Person obj = (Person) new JDKZhongJie().getInstance(new Girl());
        obj.findLove();

    }
}
