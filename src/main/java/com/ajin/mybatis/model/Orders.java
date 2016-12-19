package com.ajin.mybatis.model;

/**
 * Created by ajin on 16-12-19.
 */
public class Orders {
    private int ono;
    private String otime;
    private int cno;
    private int gno;

    public int getOno() {
        return ono;
    }

    public void setOno(int ono) {
        this.ono = ono;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ono=" + ono +
                ", otime='" + otime + '\'' +
                ", cno=" + cno +
                ", gno=" + gno +
                '}';
    }
}
