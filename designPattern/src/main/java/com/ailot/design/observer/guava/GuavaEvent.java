package com.ailot.design.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author ailot
 * @version GuavaEvent.java, 2019年04月03日 下午10:29
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，参数："+str);
    }
}
