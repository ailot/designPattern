package com.ailot.design.decorator.battercake.v2;

/**
 * @author ailot
 * @version SausageDecorator.java, 2019年04月01日 下午10:36
 */
public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+一跟香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
