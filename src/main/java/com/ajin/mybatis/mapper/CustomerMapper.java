package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.Customer;

/**
 * Created by ajin on 16-12-20.
 */
public interface CustomerMapper {
    Customer selectCustomerById(int id);
}
