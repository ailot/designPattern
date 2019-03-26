/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.design.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ailot
 * @version Leader.java, 2019年03月26日 下午9:37
 */
public class Leader {

    private Map<String,IEmployee> register = new HashMap<>();

    public Leader() {
        register.put("加密",new EmployeeA());
        register.put("解密",new EmployeeB());
        register.put("打折",new EmployeeC());
    }

    public void doing(String command){
        register.get(command).doing(command);
    }
}
