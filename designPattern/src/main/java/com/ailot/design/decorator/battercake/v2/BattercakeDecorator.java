package com.ailot.design.decorator.battercake.v2;

/**
 * @author ailot
 * @version BattercakeDecorator.java, 2019年04月01日 下午10:32
 */
public class BattercakeDecorator extends Battercake {

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }

}
