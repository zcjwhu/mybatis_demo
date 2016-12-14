package com.ajin.mybatis.dao;

import com.ajin.mybatis.mapper.UserMapper;
import com.ajin.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by ajin on 16-12-14.
 */
public class UserDaoTest {
    //第一种使用dao方式对应的单元测试
    //配置log4j.properties文件用来打印执行的日志记录，如果不不配值，虽然能够执行成功，但是会报没有log的warning,建议配置
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectUser() throws Exception {
        UserDao userDao = new UserDao(sqlSessionFactory);
        User user =userDao.selectUser(2);
        System.out.print("!!!!!!!!!"+user.getName());
    }

}