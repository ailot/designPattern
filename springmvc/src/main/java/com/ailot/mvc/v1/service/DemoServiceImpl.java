package com.ailot.mvc.v1.service;

import com.ailot.mvc.v1.annotation.Service;

/**
 * @author ailot
 * @version DemoServiceImpl.java, 2019年04月07日 下午1:37
 */

@Service
public class DemoServiceImpl implements IDemoService{
    public String get(String name) {
        return "my name is" + name;
    }
}
