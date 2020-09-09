package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.views.OrderCount;

import java.util.List;

public interface CustomerServices {

    List<Customer> findAllCustomerOrders();

    Customer findCustomerByID(long customerID);

    List<Customer> findCustomerByKeyword(String keyword);

    List<OrderCount> findOrderCount();

    Customer save(Customer customer);
}
