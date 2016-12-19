package com.ajin.mybatis.mapper;

import com.ajin.mybatis.model.CustomerOrdersMap;

/**
 * Created by ajin on 16-12-19.
 */
public interface CustomerOrdersMapper {
    public CustomerOrdersMap selectCustomerOrdersMap(int id);
}
