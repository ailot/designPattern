/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.abstractFactory;

/**
 * @author ailot
 * @version AbstractFactoryTest.java, 2019年03月18日 下午11:18
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.createCourse().record();
        courseFactory.createNote().edit();
        courseFactory.createVideo().record();
    }
}
