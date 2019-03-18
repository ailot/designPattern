/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory;

/**
 * @author lt48615
 * @version $Id: JavaCourse.java, v 0.1 2019年03月18日 下午10:46 lt48615 Exp $
 */
public class JavaCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
