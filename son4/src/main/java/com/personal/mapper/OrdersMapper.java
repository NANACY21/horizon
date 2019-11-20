package com.personal.mapper;

import com.personal.pojo.Orders;

import java.util.List;

public interface OrdersMapper {

    /**
     * 查询所有订单及对应的用户
     * @return
     */
    public List<Orders> getOrdersAndT_users();



    public Orders getOrdersAndDetailsByID(long ID);
    public List<Orders> selectLazyOrders();

}
