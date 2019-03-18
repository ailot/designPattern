/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.factory.simplefactory;

import com.ailot.design.factory.ICourse;
import com.ailot.design.factory.JavaCourse;
import com.ailot.design.factory.PythonCourse;

import javax.swing.*;

/**
 * @author ailot
 * @version CourseFactory.java, 2019年03月18日 下午10:50
 */
public class CourseFactory {

    //1 直接传类型名字
    public ICourse create0(String name){
        if ("java".equals(name)){
            return new JavaCourse();
        }
        if ("python".equals(name)){
            return new PythonCourse();
        }else {
            return null;
        }
    }

    //2 传类的名字
    public ICourse create1(String className){
        if (null != className && "" != className){
            try {
                return (ICourse) Class.forName(className).newInstance();
            } catch (Exception e) {

            }
        }
        return null;
    }

    //3 直接传类
    public ICourse create2(Class<? extends ICourse> clazz){
        if (clazz != null){
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
