package com.ailot.design.decorator.battercake.v2;

/**
 * @author ailot
 * @version BaseBattercake.java, 2019年04月01日 下午10:31
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
