package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.repositories.CustomerRepository;
import com.lambdaschool.crudyorders.views.OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    CustomerRepository custrepos;

    @Override
    public List<Customer> findAllCustomerOrders() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerByID(long customerID) {
        return custrepos.findById(customerID)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + customerID + " was not found."));
    }

    @Override
    public List<Customer> findCustomerByKeyword(String keyword) {

        List<Customer> list = custrepos.findByCustnameContainingIgnoringCase(keyword);
        return list;
    }

    @Override
    public List<OrderCount> findOrderCount() {
        List<OrderCount> list = custrepos.findOrderCount();
        return list;
    }

    @Override
    public Customer save(Customer customer) {
        return custrepos.save(customer);
    }
}
