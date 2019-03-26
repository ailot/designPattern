/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy;

import com.ailot.design.proxy.Person;

/**
 * @author ailot
 * @version son.java, 2019年03月20日 下午10:48
 */
public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("要求女的活的");
    }
}
