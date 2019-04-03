package com.ailot.design.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author ailot
 * @version GuavaEventTest.java, 2019年04月03日 下午10:30
 */
public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("你好");
    }
}
