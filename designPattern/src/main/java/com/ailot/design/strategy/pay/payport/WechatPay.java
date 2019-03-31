package com.ailot.design.strategy.pay.payport;

/**
 * @author ailot
 * @version AliPay.java, 2019年03月30日 上午11:31
 */
public class WechatPay extends Payment{
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 800;
    }
}
