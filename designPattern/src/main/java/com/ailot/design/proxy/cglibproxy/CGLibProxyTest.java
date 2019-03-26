/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.cglibproxy;

/**
 * @author ailot
 * @version CGLibProxyTest.java, 2019年03月24日 下午10:02
 */
public class CGLibProxyTest {

    public static void main(String[] args) throws Exception {
        Customer customer = (Customer) new CGLibZhongjie().getInstace(Customer.class);
        customer.findLove();
    }
}
