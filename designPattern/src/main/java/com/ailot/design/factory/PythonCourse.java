/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory;

/**
 * @author ailot
 * @version PythonCourse.java, 2019年03月18日 下午10:49
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
