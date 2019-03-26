/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy.dbroute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ailot
 * @version OrderServiceStaticProxy.java, 2019年03月20日 下午11:14
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbroute = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到DB_"+dbroute);
        DynamicDataSourceEntity.set(dbroute.toString());
        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
