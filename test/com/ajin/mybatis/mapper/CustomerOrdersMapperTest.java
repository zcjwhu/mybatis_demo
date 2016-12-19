package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.CustomerOrdersMap;
import com.ajin.mybatis.model.OrdersCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by ajin on 16-12-19.
 */
public class CustomerOrdersMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectCustomerOrdersMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            CustomerOrdersMapper customerOrdersMapper = sqlSession.getMapper(CustomerOrdersMapper.class);
            CustomerOrdersMap customerOrdersMap=customerOrdersMapper.selectCustomerOrdersMap(1);
            System.out.println(customerOrdersMap);
        }finally {
            sqlSession.close();
        }
    }

}