package com.ailot.design.observer.events.mouseevent;

import com.ailot.design.observer.events.core.EventListener;

/**
 * @author ailot
 * @version Mouse.java, 2019年04月03日 下午10:13
 */
public class Mouse extends EventListener {

    public void click(){
        System.out.println("调用单击");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick(){
        System.out.println("调用双击");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up(){
        System.out.println("弹起");
        this.trigger(MouseEventType.ON_UP);
    }
}
