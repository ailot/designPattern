/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.factorymethod;

/**
 * @author ailot
 * @version FactoryMethodFactoryTest.java, 2019年03月18日 下午11:08
 */
public class FactoryMethodFactoryTest {

    public static void main(String[] args) {
        ICourseFactory javaFactory = new JavaCourseFactory();
        javaFactory.create().record();

        ICourseFactory pythonFactory = new PythonCourseFactory();
        pythonFactory.create().record();
    }
}
