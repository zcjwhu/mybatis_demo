package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.User;
import com.ajin.mybatis.model.UserExt;
import com.ajin.mybatis.model.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ajin on 16-12-14.
 */
public class UserMapperTest {
    //第二种使用dao方式对应的单元测试
    //配置log4j.properties文件用来打印执行的日志记录，如果不不配值，虽然能够执行成功，但是会报没有log的warning,建议配置
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(2);
            System.out.print("!!!"+user.getName());
        } finally {
            session.close();
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user= new User();
        user.setName("zcj");
        user.setPassword("zcj");
        SqlSession sqlSession= sqlSessionFactory.openSession();
        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            //对于插入，需要执行commit提交一下
            sqlSession.commit();
            System.out.println(user.getId());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession= sqlSessionFactory.openSession();
        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(9);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() throws Exception {
        User user =new User();
        user.setId(12);
        user.setName("qqx");
        user.setPassword("qqx");
        SqlSession sqlSession= sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectMulUser() throws Exception {
        UserVo userVo = new UserVo();
        User user = new User();
        user.setName("qqx12");
        userVo.setUser(user);
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        List<User> list=userMapper.selectMulUser(userVo);
        sqlSession.close();
    }

    @Test
    public void selectUserCount() throws Exception {
        UserVo userVo = new UserVo();
        User user = new User();
        user.setName("qqx12");
        userVo.setUser(user);
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        int count=userMapper.selectUserCount(userVo);
        sqlSession.close();
    }

    @Test
    public void selectByIdResultMap() throws Exception {
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user=userMapper.selectByIdResultMap(2);
        sqlSession.close();
    }

}