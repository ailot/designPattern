package com.ailot.design.decorator.battercake.v1;

/**
 * @author ailot
 * @version BattercakeTest.java, 2019年04月01日 下午10:27
 */
public class BattercakeTest {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg()+",总价："+battercake.getPrice());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg()+",总价："+battercakeWithEgg.getPrice());

        BattercakeWithEggAndSausage battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg()+",总价："+battercakeWithEggAndSausage.getPrice());
    }
}
