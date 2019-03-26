/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy.dbroute;

/**
 * @author ailot
 * @version OrderDao.java, 2019年03月20日 下午11:01
 */
public class OrderDao {

    public int createOrder(Order order){
        System.out.println("创建订单完成");
        return 1;
    }
}
