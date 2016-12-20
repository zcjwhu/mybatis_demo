package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.OrdersCustomerMap;
import com.ajin.mybatis.model.OrdersCustomer;

import java.util.List;

/**
 * Created by ajin on 16-12-19.
 */
public interface OrdersCustomerMapper {
    //基于resultType方式一对一查询
    public OrdersCustomer selectOrdersCustomerById(int id);
    //基于resultMap方式一对一查询
    public OrdersCustomerMap selectOrdersCustomerMapById(int id);
    //延迟加载接口方法定义
    public List<OrdersCustomerMap> selectOrdersCustomerLazyLoading();
}
