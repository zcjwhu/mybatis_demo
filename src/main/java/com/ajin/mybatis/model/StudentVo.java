package com.ajin.mybatis.model;

import java.util.List;

/**
 * Created by ajin on 16-12-16.
 */
public class StudentVo {
    private Student student;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
