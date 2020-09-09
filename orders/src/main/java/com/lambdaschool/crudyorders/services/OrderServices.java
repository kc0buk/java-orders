package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;
//import com.lambdaschool.crudyorders.views.CustomerAdvanceAmt;

import java.util.List;

public interface OrderServices {

    Order findOrderByID(long orderID);

    List<Order> getCustAdvanceAmt(double amount);

    Order save(Order order);
}
