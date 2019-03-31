package com.ailot.design.strategy.pay.payport;

import jdk.nashorn.internal.scripts.JD;
import sun.security.krb5.internal.PAData;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ailot
 * @version PayStrategy.java, 2019年03月30日 下午12:49
 */
public class PayStrategy {

    public static final String ALI_PAY = "alipay";
    public static final String JD_PAY = "jdpay";
    public static final String APPLE_PAY = "applepay";
    public static final String UNION_PAY = "unionpay";
    public static final String WECHAT_PAY = "wechatpay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> paystrategy = new HashMap<>();

    static {
        paystrategy.put(ALI_PAY,new AliPay());
        paystrategy.put(JD_PAY,new JDPay());
        paystrategy.put(APPLE_PAY,new ApplePay());
        paystrategy.put(UNION_PAY,new UnionPay());
        paystrategy.put(WECHAT_PAY,new WechatPay());
    }

    public static Payment get(String key){
        if (!paystrategy.containsKey(key)){
            return paystrategy.get(DEFAULT_PAY);
        }
        return paystrategy.get(key);
    }
}
