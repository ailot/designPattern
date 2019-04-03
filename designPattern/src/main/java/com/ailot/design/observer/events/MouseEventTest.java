package com.ailot.design.observer.events;

import com.ailot.design.observer.events.mouseevent.Mouse;
import com.ailot.design.observer.events.mouseevent.MouseEventCallback;
import com.ailot.design.observer.events.mouseevent.MouseEventType;

/**
 * @author ailot
 * @version MouseEventTest.java, 2019年04月03日 下午10:19
 */
public class MouseEventTest {

    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        //注册事件
        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK,callback);
        mouse.addListener(MouseEventType.ON_DOUBLE_CLICK,callback);

        //调用方法
        mouse.click();
        mouse.doubleClick();
    }
}
