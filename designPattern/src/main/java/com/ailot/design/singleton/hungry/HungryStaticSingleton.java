/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.singleton.hungry;

/**
 * @author ailot
 * @version HungrySingleton.java, 2019年03月19日 下午10:19
 */
public class HungryStaticSingleton {

    public static final HungryStaticSingleton hungrySingleton ;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance(){
        return hungrySingleton;
    }
}
