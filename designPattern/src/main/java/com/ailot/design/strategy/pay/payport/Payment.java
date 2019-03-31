package com.ailot.design.strategy.pay.payport;

import com.ailot.design.strategy.pay.MsgResult;

/**
 * @author ailot
 * @version Payment.java, 2019年03月30日 上午11:24
 */
public abstract class Payment {

    public abstract String getName();

    protected abstract double queryBalance(String uid);

    public MsgResult pay(String uid,double amount){
        if (queryBalance(uid) < amount){
            return new MsgResult(500,"余额不足","支付失败");
        }
        return new MsgResult(200,"支付金额"+amount,"支付成功，账户余额："+(queryBalance(uid)-amount));
    }
}
