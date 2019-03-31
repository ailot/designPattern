package com.ailot.design.template.course;

/**
 * @author ailot
 * @version JavaCourse.java, 2019年03月30日 下午9:30
 */
public class JavaCourse extends NetworkCourse {
    @Override
    protected void checkHomework() {
        System.out.println("检查JAVA作业");
    }
}
