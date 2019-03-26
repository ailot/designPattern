/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy.dbroute;

/**
 * @author ailot
 * @version OrderServiceImpl.java, 2019年03月20日 下午11:03
 */
public class OrderServiceImpl implements IOrderService {


    private OrderDao orderDao;

     public OrderServiceImpl(){
         orderDao = new OrderDao();
     }

    @Override
    public int createOrder(Order order) {
        System.out.println("orderService调用orderDao创建订单");
        return orderDao.createOrder(order);
    }
}
