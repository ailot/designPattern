package com.ailot.design.adapter.loginadapter.v1.service;

import com.ailot.design.adapter.loginadapter.ResultMsg;

/**
 * @author ailot
 * @version singleService.java, 2019年03月31日 下午8:30
 */
public class SingleService {

    public ResultMsg regist(String username,String password){
        return new ResultMsg(200,"注册成功","注册成功");
    }


    public ResultMsg login(String username,String password){
        return new ResultMsg(200,"登录成功","登录成功");
    }

}
