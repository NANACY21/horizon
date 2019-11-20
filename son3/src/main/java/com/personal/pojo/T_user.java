package com.personal.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class T_user  implements Serializable {
    private Long ID;
    private String USERNAME;
    private Date BIRTHDAY;
    private String SEX;
    private String ADDRESS;

    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public Date getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Date BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    @Override
    public String toString() {
        return "T_user{" +
                "ID=" + ID +
                ", USERNAME='" + USERNAME + '\'' +
                ", BIRTHDAY=" + BIRTHDAY +
                ", SEX='" + SEX + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                '}';
    }
}
