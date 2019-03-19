/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.threadlocal;

/**
 * @author ailot
 * @version ThreadLocalSingleton.java, 2019年03月19日 下午11:06
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    public static final ThreadLocal<ThreadLocalSingleton> threadLocalInstace = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstace.get();
    }
}
