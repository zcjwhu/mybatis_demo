package com.ajin.mybatis.model;

/**
 * Created by ajin on 16-12-16.
 */
public class UserExt extends User {
    private String sex;
    private String address;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
