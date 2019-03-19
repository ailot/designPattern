/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ailot
 * @version ContainerSingleton.java, 2019年03月19日 下午11:00
 */
public class ContainerSingleton {

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    private ContainerSingleton() {
    }

    public static Object getBean(String className){
        if (!ioc.containsKey(className)){
            try {
                Object obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
                return obj;
            } catch (Exception e) {

            }
        }
        return ioc.get(className);
    }
}
