package com.ailot.design.decorator.battercake.v2;

/**
 * @author ailot
 * @version EggDecorator.java, 2019年04月01日 下午10:34
 */
public class EggDecorator extends BattercakeDecorator{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+一个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
