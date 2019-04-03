package com.ailot.design.adapter.loginadapter.v1.service;

import com.ailot.design.adapter.loginadapter.ResultMsg;

/**
 * @author ailot
 * @version SingleForThirdServiceTest.java, 2019年03月31日 下午9:21
 */
public class SingleForThirdService extends SingleService{

    public ResultMsg loginForQQ() {
        return ResultMsg.success();
    }

    public ResultMsg loginForWecat() {
        return ResultMsg.success();
    }

    public ResultMsg loginForMobile() {
        return ResultMsg.success();
    }
}
