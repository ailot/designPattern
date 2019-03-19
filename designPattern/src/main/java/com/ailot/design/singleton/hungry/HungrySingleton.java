/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.hungry;

/**
 * @author ailot
 * @version HungrySingleton.java, 2019年03月19日 下午10:19
 */
public class HungrySingleton {

    public static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
