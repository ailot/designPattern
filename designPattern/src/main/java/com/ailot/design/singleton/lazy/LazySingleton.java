/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.lazy;

/**
 * @author ailot
 * @version LazySingleton.java, 2019年03月19日 下午10:23
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            return new LazySingleton();
        }
        return lazySingleton;
    }
}
