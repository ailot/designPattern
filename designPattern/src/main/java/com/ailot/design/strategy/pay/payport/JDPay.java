package com.ailot.design.strategy.pay.payport;

/**
 * @author ailot
 * @version AliPay.java, 2019年03月30日 上午11:31
 */
public class JDPay extends Payment{
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
