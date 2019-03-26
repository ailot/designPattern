package com.ailot.design.strategy.promotion;

/**
 * @author ailot
 * @version GroupbuyStrategy.java, 2019年03月26日 下午10:50
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("组团");
    }
}
