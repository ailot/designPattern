package com.ailot.design.template.course;

/**
 * @author ailot
 * @version NetworkCourse.java, 2019年03月30日 下午9:17
 */
public abstract class NetworkCourse {

    protected final void createCourse(){

        //1.发布预习资料
        postPreResource();

        //2.备课
        createPPT();

        //3.直播
        liveVideo();

        //4.提交笔记
        postNote();

        //5.提交源码
        postSource();

        //6.检查作业
        if (needHomework()) {
            checkHomework();
        }

    }

    protected boolean needHomework(){
        return false;
    }

    protected abstract void checkHomework();


    private final void postSource() {
        System.out.println("提交源码");
    }

    private final void postNote() {
        System.out.println("提交笔记");
    }

    private final void liveVideo() {
        System.out.println("在线直播");
    }

    private final void createPPT() {

        System.out.println("备课，准备PPT");
    }

    private final void postPreResource() {
        System.out.println("发布预习资料");
    }


}
