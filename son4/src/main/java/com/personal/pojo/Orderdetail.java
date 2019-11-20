package com.personal.pojo;

public class Orderdetail {
    private long ID;
    private long ORDERS_ID;
//    private long ITEMS_ID;
    private long ITEMS_NUM;
    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getORDERS_ID() {
        return ORDERS_ID;
    }

    public void setORDERS_ID(long ORDERS_ID) {
        this.ORDERS_ID = ORDERS_ID;
    }

//    public long getITEMS_ID() {
//        return ITEMS_ID;
//    }
//
//    public void setITEMS_ID(long ITEMS_ID) {
//        this.ITEMS_ID = ITEMS_ID;
//    }

    public long getITEMS_NUM() {
        return ITEMS_NUM;
    }

    public void setITEMS_NUM(long ITEMS_NUM) {
        this.ITEMS_NUM = ITEMS_NUM;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "ID=" + ID +
                ", ORDERS_ID=" + ORDERS_ID +
                ", ITEMS_NUM=" + ITEMS_NUM +
                '}';
    }
}
