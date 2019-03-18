/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.abstractFactory;

import com.ailot.design.factory.*;

/**
 * @author ailot
 * @version JavaCourseFactory.java, 2019年03月18日 下午11:19
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }
}
