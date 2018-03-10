package com.ikook.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private Integer id;
    private String cname;

    // 使用 set 集合来关联学生类
    private Set<Student> students = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                '}';
    }
}
