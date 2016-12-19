package com.ajin.mybatis.model;

/**
 * Created by ajin on 16-12-19.
 */
public class OrdersCustomer extends Orders {
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    private String cphone;

    @Override
    public String toString() {
        return "OrdersCustomer{" +
                "ono='" + this.getOno() + '\'' +
                "otime='" + this.getOtime() + '\'' +
                "cno='" + this.getCno() + '\'' +
                "gno='" + this.getGno() + '\'' +
                "cname='" + cname + '\'' +
                ", cphone='" + cphone + '\'' +
                '}';
    }
}
