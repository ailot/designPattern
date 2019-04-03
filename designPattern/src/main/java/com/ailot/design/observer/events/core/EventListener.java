package com.ailot.design.observer.events.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ailot
 * @version EventListener.java, 2019年04月03日 下午9:56
 */
public class EventListener {

    protected Map<String, Event> eventMap = new HashMap<>();

    public void addListener(String eventType, Object target) {

        try {
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void addListener(String event, Object target, Method callback) {
        eventMap.put(event, new Event(target, callback));
    }

    //事件触发
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        //发起回调
        if (event.getCallback() != null){
            //反射调用函数
            try {
                event.getCallback().invoke(event.getTarget(),event);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    //事件名称触发
    protected void trigger(String trigger){
        if (eventMap.containsKey(trigger)){
            trigger(eventMap.get(trigger));
        }
    }



    private String toUpperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
