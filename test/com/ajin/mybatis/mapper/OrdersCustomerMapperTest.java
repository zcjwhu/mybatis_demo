package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.OrdersCustomerMap;
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
public class OrdersCustomerMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void selectOrdersCustomerById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersCustomerMapper ordersCustomerMapper = sqlSession.getMapper(OrdersCustomerMapper.class);
            OrdersCustomer ordersCustomer=ordersCustomerMapper.selectOrdersCustomerById(5);
            System.out.println(ordersCustomer);
        }finally {
           sqlSession.close();
        }
    }

    @Test
    public void selectOrdersCustomerMapById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersCustomerMapper ordersCustomerMapper = sqlSession.getMapper(OrdersCustomerMapper.class);
            OrdersCustomerMap ordersCustomer=ordersCustomerMapper.selectOrdersCustomerMapById(5);
            System.out.println(ordersCustomer);
        }finally {
            sqlSession.close();
        }
    }

}