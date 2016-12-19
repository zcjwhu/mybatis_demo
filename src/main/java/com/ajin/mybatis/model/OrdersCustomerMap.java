package com.ajin.mybatis.model;

/**
 * Created by ajin on 16-12-19.
 */
public class OrdersCustomerMap extends Orders {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
