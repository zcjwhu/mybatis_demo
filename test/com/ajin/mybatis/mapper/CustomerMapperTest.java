package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.Customer;
import com.ajin.mybatis.model.CustomerOrdersMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by ajin on 16-12-20.
 */
public class CustomerMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectCustomerById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer =customerMapper.selectCustomerById(1);
            System.out.print(customer);
        }finally {
            sqlSession.close();
        }
    }

}