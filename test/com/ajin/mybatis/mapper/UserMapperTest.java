package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;

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

}