package com.ailot.design.strategy.promotion;

/**
 * @author ailot
 * @version CashbakStrategy.java, 2019年03月26日 下午10:50
 */
public class CashbakStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现");
    }
}
