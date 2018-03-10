package com.ikook.manytomany;

import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.junit.Test;

public class ManyToMany {

    // 存储数据
    @Test
    public void test1() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        Student student1 = new Student();
        student1.setSname("张三");
        Student student2 = new Student();
        student2.setSname("李四");

        Course course1 = new Course();
        course1.setCname("Java");
        Course course2 = new Course();
        course2.setCname("Python");

        // 建立关联关系
        // 学生关联科目
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);

        student2.getCourses().add(course1);
        student2.getCourses().add(course2);

        // 科目关联学生
//        course1.getStudents().add(student1);
//        course1.getStudents().add(student1);
//        course2.getStudents().add(student1);
//        course2.getStudents().add(student1);

        // 存储
        session.save(student1);
        session.save(student2);
        session.save(course1);
        session.save(course2);

        session.beginTransaction().commit();
        session.close();

    }

}
