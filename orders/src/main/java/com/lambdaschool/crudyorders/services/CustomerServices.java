package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;

import java.util.List;

public interface CustomerServices {

    List<Customer> findAllCustomerOrders();

    Customer findCustomerByID(long customerID);

    Customer save(Customer customer);
}
