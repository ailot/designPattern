package com.ailot.design.decorator.battercake.v2;

/**
 * @author ailot
 * @version BatterDecorator.java, 2019年04月01日 下午10:38
 */
public class BatterDecorator {

    public static void main(String[] args) {
        Battercake battercake = new BaseBattercake();

        battercake = new EggDecorator(battercake);

        battercake = new SausageDecorator(battercake);

        battercake = new EggDecorator(battercake);

        System.out.println(battercake.getMsg()+",总价："+battercake.getPrice());


    }
}
