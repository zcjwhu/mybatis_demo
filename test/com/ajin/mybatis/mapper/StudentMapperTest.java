package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.Student;
import com.ajin.mybatis.model.StudentVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ajin on 16-12-16.
 */
public class StudentMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectStudentMul() throws Exception {
        StudentVo studentVo= new StudentVo();
       Student student = new Student();
       student.setSname("zcj");
       student.setSsex("female");
       List<Integer> ids = new ArrayList<Integer>();
       ids.add(3);
       ids.add(4);
       studentVo.setIds(ids);
       studentVo.setStudent(student);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list=studentMapper.selectStudentMul(studentVo);
            System.out.print(list);
        }finally {
            sqlSession.close();
        }
    }

}