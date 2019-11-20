package com.personal.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Orders implements Serializable {
    private Long ID;
    private String ORDERID;
    private Date CREATETIME;
    private String NOTE;

    //Orders订单要依赖于T_user用户，二者一对一关联
    private T_user t_user;
    private List<Orderdetail> orderDetail;

    public List<Orderdetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<Orderdetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getORDERID() {
        return ORDERID;
    }

    public void setORDERID(String ORDERID) {
        this.ORDERID = ORDERID;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public T_user getT_user() {
        return t_user;
    }

    public void setT_user(T_user t_user) {
        this.t_user = t_user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", ORDERID='" + ORDERID + '\'' +
                ", CREATETIME=" + CREATETIME +
                ", NOTE='" + NOTE + '\'' +
                ", t_user=" + t_user +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
