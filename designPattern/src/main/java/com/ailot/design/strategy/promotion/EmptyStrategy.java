package com.ailot.design.strategy.promotion;

/**
 * @author ailot
 * @version EmptyStrategy.java, 2019年03月26日 下午10:47
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
