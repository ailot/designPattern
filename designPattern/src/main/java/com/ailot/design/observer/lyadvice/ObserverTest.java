package com.ailot.design.observer.lyadvice;

/**
 * @author ailot
 * @version ObserverTest.java, 2019年04月01日 下午11:31
 */
public class ObserverTest {

    public static void main(String[] args) {
        LYPer lyPer = LYPer.getInstance();
        Question question = new Question();
        question.setName("tom");
        question.setContant("地球有多大？");


        Developer devA = new Developer("A");
        Developer devB = new Developer("B");

        lyPer.addObserver(devA);
        lyPer.addObserver(devB);
        lyPer.publishQuestion(question);

    }
}
