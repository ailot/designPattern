/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.proxy.staticproxy;

import com.ailot.design.proxy.Person;

/**
 * @author ailot
 * @version Father.java, 2019年03月20日 下午10:53
 */
public class Father implements Person {

    private Person person;

    public Father(Person person){
        this.person = person;
    }


    @Override
    public void findLove() {
        System.out.println("物色对象");
        this.person.findLove();
        System.out.println("完成");
    }
}
