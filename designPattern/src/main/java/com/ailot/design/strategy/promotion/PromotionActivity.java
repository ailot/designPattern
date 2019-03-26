package com.ailot.design.strategy.promotion;

/**
 * @author ailot
 * @version PromotionActivity.java, 2019年03月26日 下午10:51
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }
}
