package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.views.OrderCount;

import java.util.List;

public interface CustomerServices {

    // Used to return all customers with orders in CustomerController
    List<Customer> findAllCustomerOrders();

    // Used to return specific customer by ID (custcode) in CustomerController
    Customer findCustomerByID(long customerID);

    // Used by CustomerController to generate list of customers containing specified keyword
    List<Customer> findCustomerByKeyword(String keyword);

    // Used by CustomerController to generate list of customers with number of orders placed
    List<OrderCount> findOrderCount();

    // Used by POST & PUT request in CustomerController
    Customer save(Customer customer);

    // Used by PATCH request in CustomerController
    Customer update(Customer customer, long custcode);

    // Used by DELETE request in CustomerController
    void delete(long custcode);
}
