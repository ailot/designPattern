package com.ailot.design.strategy.promotion;

/**
 * @author ailot
 * @version PromotionActivityTest.java, 2019年03月26日 下午10:53
 */
public class PromotionActivityTest {

    public static void main(String[] args) {
        /*PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
        PromotionActivity activity1111 = new PromotionActivity(new CashbakStrategy());

        activity618.execute();

        activity1111.execute();*/

        String promotionKey = "COUPON";
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);

        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.execute();


    }
}
