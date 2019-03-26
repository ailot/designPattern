/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy.dbroute;

/**
 * @author ailot
 * @version DynamicDataSourceEntity.java, 2019年03月20日 下午11:05
 */
public class DynamicDataSourceEntity {

    public static final ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntity(){}

    public static String get(){
        return local.get();
    }

    public static void set(String source){
        local.set(source);
    }

    public static void set(Long year){
        local.set("DB"+ year);
    }

    public static void restore(){
        local.set(null);
    }
}
