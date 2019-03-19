/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.lazy;

/**
 * @author ailot
 * @version LazyInnerClassSingleton.java, 2019年03月19日 下午10:43
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {

        if (LazyHolder.lazy != null){
            throw new RuntimeException("forbidden");
        }

    }

    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.lazy;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }
}
