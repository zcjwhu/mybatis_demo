package com.ajin.mybatis.model;

import java.util.List;

/**
 * Created by ajin on 16-12-19.
 */
public class CustomerOrdersMap extends Customer {
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
