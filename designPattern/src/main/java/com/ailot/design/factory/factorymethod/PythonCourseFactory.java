/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.factorymethod;

import com.ailot.design.factory.ICourse;
import com.ailot.design.factory.PythonCourse;

/**
 * @author ailot
 * @version PythonCourseFactory.java, 2019年03月18日 下午11:07
 */
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
