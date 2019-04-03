package com.ailot.design.observer.events.mouseevent;

import com.ailot.design.observer.events.core.Event;

/**
 * @author ailot
 * @version MouseEventCallback.java, 2019年04月03日 下午10:16
 */
public class MouseEventCallback {

    public void onClick(Event e){
        System.out.println("========触发单击============\n"+e.toString());
    }

    public void onDoubleClick(Event e){
        System.out.println("===========触发双击===========\n"+e.toString());
    }
}
