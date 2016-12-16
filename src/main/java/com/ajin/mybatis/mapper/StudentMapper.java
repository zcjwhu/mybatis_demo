package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.Student;
import com.ajin.mybatis.model.StudentVo;

import java.util.List;

/**
 * Created by ajin on 16-12-16.
 */
public interface StudentMapper {

    List<Student> selectStudentMul(StudentVo studentVo);
}
