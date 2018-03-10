package com.ikook.manytomany;

import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.junit.Test;

public class ManyToManyTest {

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
        course1.getStudents().add(student1);
        course1.getStudents().add(student2);

        course2.getStudents().add(student1);
        course2.getStudents().add(student2);

        // 存储
        session.save(student1);
        session.save(student2);
        session.save(course1);
        session.save(course2);

        session.beginTransaction().commit();
        session.close();

    }

    // 多对多级联保存：学生级联课程，需要在学生 Student.hbm.xml 添加级联保存
    @Test
    public void test2() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        // 1.创建课程
        Course course = new Course();
        course.setCname("PHP");

        // 2.创建学生
        Student student = new Student();
        student.setSname("王五");

        // 3.关联-- 学生关联课程
        student.getCourses().add(course);

        // 4.保存
        session.save(student);

        session.getTransaction().commit();
        session.close();
    }

    // 级联删除
        // 1. 没有任何配置将删除 Student 及在中间表中的数据
        // 2. 配置双向级联删除
        // 3. 配置双向级联删除 + 课程放权
    @Test
    public void test3() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class, 5);
        session.delete(student);

        session.getTransaction().commit();
        session.close();
    }


}
