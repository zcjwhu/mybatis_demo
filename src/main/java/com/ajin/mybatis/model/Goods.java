package com.ajin.mybatis.model;

/**
 * Created by ajin on 16-12-19.
 */
public class Goods {
    private int gno;
    private String gname;

    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public float getGprice() {
        return gprice;
    }

    public void setGprice(float gprice) {
        this.gprice = gprice;
    }

    private String gtype;
    private float gprice;

}
