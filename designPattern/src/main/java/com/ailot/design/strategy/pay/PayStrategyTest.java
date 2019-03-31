package com.ailot.design.strategy.pay;

import com.ailot.design.strategy.pay.payport.PayStrategy;

/**
 * @author ailot
 * @version PayStrategyTest.java, 2019年03月30日 上午11:35
 */
public class PayStrategyTest {

    public static void main(String[] args) {
        Order order = new Order("1","2019",300);

        MsgResult msgResult = order.pay(PayStrategy.ALI_PAY);
        System.out.println(msgResult.toString());
    }
}
