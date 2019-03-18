/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.simplefactory;

import com.ailot.design.factory.ICourse;
import com.ailot.design.factory.JavaCourse;
import com.ailot.design.factory.PythonCourse;

/**
 * @author ailot
 * @version SimpleFactoryTest.java, 2019年03月18日 下午10:58
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        course.record();

        CourseFactory courseFactory = new CourseFactory();
        courseFactory.create0("java").record();
        courseFactory.create0("python").record();

        courseFactory.create1("com.ailot.design.factory.JavaCourse").record();

        courseFactory.create2(PythonCourse.class).record();
    }
}
