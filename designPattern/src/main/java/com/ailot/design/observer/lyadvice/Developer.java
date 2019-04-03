package com.ailot.design.observer.lyadvice;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ailot
 * @version Developer.java, 2019年04月01日 下午11:26
 */
public class Developer implements Observer {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        LYPer lyPer = (LYPer) o;
        Question question = (Question) arg;
        System.out.println("=============================");
        System.out.println(name + "老铁你好！\n" +
         "您收到来自鱼乐圈的提问：\n"+
        question.getContant() +"\n" +
        "\t" + question.getName() +"\n");
    }
}
