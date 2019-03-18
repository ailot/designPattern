/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory;

/**
 * @author ailot
 * @version JavaVideo.java, 2019年03月18日 下午11:15
 */
public class JavaVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
