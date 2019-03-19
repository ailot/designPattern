/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @author ailot
 * @version LazySingletonTest.java, 2019年03月19日 下午10:46
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        Class<?> clazz = LazyInnerClassSingleton.class;

        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object obj1 = constructor.newInstance(null);

            Object obj2 = LazyInnerClassSingleton.getInstance();

            System.out.println(obj1.equals(obj2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
