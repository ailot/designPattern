package com.ailot.design.adapter.poweradapter;

/**
 * @author ailot
 * @version PowerAdapterTest.java, 2019年03月31日 下午4:08
 */
public class PowerAdapterTest {

    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5();
    }
}
