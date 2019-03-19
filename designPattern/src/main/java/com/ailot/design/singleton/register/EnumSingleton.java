/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.register;

/**
 * @author ailot
 * @version EnumSingleton.java, 2019年03月19日 下午10:55
 */
public enum  EnumSingleton {

    INSTANC;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANC;
    }
}
