package com.ailot.design.strategy.promotion;

/**
 * @author ailot
 * @version CouponStrategy.java, 2019年03月26日 下午10:49
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("优惠券价格");
    }
}
