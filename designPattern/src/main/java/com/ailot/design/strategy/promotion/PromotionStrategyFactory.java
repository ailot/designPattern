package com.ailot.design.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ailot
 * @version PromotionStrategyFactory.java, 2019年03月26日 下午10:55
 */
public class PromotionStrategyFactory {

    private static Map<String,PromotionStrategy> map = new HashMap<>();

    static {
        map.put(PromotionKey.COUPON,new CouponStrategy());
        map.put(PromotionKey.CASHBACK,new CashbakStrategy());
        map.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
         PromotionStrategy promotionStrategy = map.get(promotionKey);
         return promotionStrategy == null ? new EmptyStrategy() : promotionStrategy;
    }


    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
