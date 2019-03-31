package com.ailot.design.strategy.pay.payport;

/**
 * @author ailot
 * @version AliPay.java, 2019年03月30日 上午11:31
 */
public class AliPay extends Payment{
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 1900;
    }
}
