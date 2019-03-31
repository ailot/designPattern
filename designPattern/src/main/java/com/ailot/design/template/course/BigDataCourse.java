package com.ailot.design.template.course;

/**
 * @author ailot
 * @version BigDataCourse.java, 2019年03月30日 下午9:32
 */
public class BigDataCourse extends NetworkCourse{

    private boolean checked;

    @Override
    protected void checkHomework() {
        System.out.println("检查大数据课程");
    }

    @Override
    protected boolean needHomework() {
        return checked;
    }

    public BigDataCourse(boolean checked) {
        this.checked = checked;
    }
}
