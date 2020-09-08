package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerServices customerServices;

    // GET /customers/orders - Returns all customers with their orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomerOrders() {
        List<Customer> list = customerServices.findAllCustomerOrders();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // GET /customers/customer/{id} - Returns the customer and their orders with the given customer id

    // GET /customers/namelike/{likename} - Returns all customers and their orders with a customer name containing
    // the given substring
}
