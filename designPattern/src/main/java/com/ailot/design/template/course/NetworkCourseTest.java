package com.ailot.design.template.course;

/**
 * @author ailot
 * @version NetworkCourseTest.java, 2019年03月30日 下午9:34
 */
public class NetworkCourseTest {

    public static void main(String[] args) {
        new JavaCourse().createCourse();


        new BigDataCourse(true).createCourse();
    }
}
