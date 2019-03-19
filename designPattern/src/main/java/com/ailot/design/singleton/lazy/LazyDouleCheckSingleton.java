/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.lazy;

/**
 * @author ailot
 * @version LazySingleton.java, 2019年03月19日 下午10:23
 */
public class LazyDouleCheckSingleton {

    private static LazyDouleCheckSingleton lazySingleton = null;

    private LazyDouleCheckSingleton() {
    }

    public static LazyDouleCheckSingleton getInstance(){
        if (lazySingleton == null){
            synchronized (LazyDouleCheckSingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazyDouleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }
}
