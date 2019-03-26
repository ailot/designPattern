/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.delegate.simple;

/**
 * @author ailot
 * @version Boss.java, 2019年03月26日 下午9:36
 */
public class Boss {

    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
