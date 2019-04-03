package com.ailot.design.observer.lyadvice;

import java.util.Observable;

/**
 * @author ailot
 * @version LYPer.java, 2019年04月01日 下午11:19
 */
public class LYPer extends Observable {

    private static LYPer lyPer = null;


    private LYPer() {
    }

    public static LYPer getInstance(){
        if (lyPer == null){
            lyPer = new LYPer();
        }
        return lyPer;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getName() + "在鱼乐圈提了一个问题！");
        setChanged();
        notifyObservers(question);
    }

}
