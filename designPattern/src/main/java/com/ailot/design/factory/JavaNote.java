/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory;

/**
 * @author ailot
 * @version JavaNote.java, 2019年03月18日 下午11:17
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("记录java笔记");
    }
}
