/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.lyproxy;

import com.ailot.design.proxy.Person;
import com.ailot.design.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * @author ailot
 * @version JDKProxyTest.java, 2019年03月21日 下午8:47
 */
public class LYProxyTest {

    public static void main(String[] args) {
        Person obj = (Person) new LYZhongJie().getInstance(new Girl());
        obj.findLove();

    }
}
