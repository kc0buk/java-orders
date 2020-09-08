package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;

public interface OrderServices {

    Order findOrderByID(long orderID);

    Order save(Order order);
}
