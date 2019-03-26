/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy.dbroute;

import java.util.Date;

/**
 * @author ailot
 * @version DynamicDBRouteTest.java, 2019年03月20日 下午11:21
 */
public class DynamicDBRouteTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setCreateTime(new Date().getTime());
        //IOrderService iOrderService = new OrderServiceStaticProxy(new OrderServiceImpl());
        IOrderService iOrderService = (IOrderService) new OrderServiceDynamicProxy().getInstan(new OrderServiceImpl());
        iOrderService.createOrder(order);
    }
}
