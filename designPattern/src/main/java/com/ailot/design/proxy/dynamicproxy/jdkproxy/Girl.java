/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.dynamicproxy.jdkproxy;

import com.ailot.design.proxy.Person;

/**
 * @author ailot
 * @version Girl.java, 2019年03月20日 下午11:26
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
    }
}
