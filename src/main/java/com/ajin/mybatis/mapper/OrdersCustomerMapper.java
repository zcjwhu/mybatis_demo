package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.OrdersCustomerMap;
import com.ajin.mybatis.model.OrdersCustomer;

/**
 * Created by ajin on 16-12-19.
 */
public interface OrdersCustomerMapper {
    public OrdersCustomer selectOrdersCustomerById(int id);
    public OrdersCustomerMap selectOrdersCustomerMapById(int id);
}
