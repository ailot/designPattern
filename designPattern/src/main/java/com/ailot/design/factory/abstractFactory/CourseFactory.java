/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.abstractFactory;

import com.ailot.design.factory.ICourse;
import com.ailot.design.factory.INote;
import com.ailot.design.factory.IVideo;

/**
 * @author ailot
 * @version CourseFactory.java, 2019年03月18日 下午11:11
 */
public interface CourseFactory {

    INote createNote();

    IVideo createVideo();

    ICourse createCourse();

}
