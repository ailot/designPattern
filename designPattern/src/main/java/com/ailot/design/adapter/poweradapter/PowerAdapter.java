package com.ailot.design.adapter.poweradapter;

import java.lang.reflect.AccessibleObject;

/**
 * @author ailot
 * @version PowerAdapter.java, 2019年03月31日 下午4:04
 */
public class PowerAdapter implements DC5{

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("输入："+adapterInput+",输出："+ adapterOutput);
        return adapterInput;
    }
}
