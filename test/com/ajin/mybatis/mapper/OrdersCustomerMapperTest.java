package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.Customer;
import com.ajin.mybatis.model.OrdersCustomerMap;
import com.ajin.mybatis.model.OrdersCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

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

    @Test
    public void selectOrdersCustomerLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            OrdersCustomerMapper ordersCustomerMapper = sqlSession.getMapper(OrdersCustomerMapper.class);
            //在执行下面这句的时候，只是会执行对于订单表的单表查询
//            日志输出如下：
//            DEBUG [main] - ==>  Preparing: select * from orders;
//            DEBUG [main] - ==> Parameters:
//            DEBUG [main] - <==      Total: 7
            List<OrdersCustomerMap> lists=ordersCustomerMapper.selectOrdersCustomerLazyLoading();
            for(OrdersCustomerMap list:lists){
                //在执行这一句话时才会延迟加载去获得所关联的用户信息
//                日志输出如下：
//                DEBUG [main] - ==>  Preparing: select * from customer where cno=?
//                DEBUG [main] - ==> Parameters: 1(Integer)
//                        DEBUG [main] - <==      Total: 1
//                Customer{cno=1, cname='zcj', csex='male', cphone='13036144569', caddress='wuhan'}
                //并且在查询相同的id时，并不会从新生成sql语句，这就涉及到一级缓存了
                Customer customer =list.getCustomer();
                System.out.println(customer);

            }
        }finally {
            sqlSession.close();
        }
    }


}