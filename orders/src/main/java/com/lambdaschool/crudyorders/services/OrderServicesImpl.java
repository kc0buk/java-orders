package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.repositories.OrderRepository;
//import com.lambdaschool.crudyorders.views.CustomerAdvanceAmt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices {

    @Autowired
    OrderRepository ordersrepos;

    @Override
    public Order findOrderByID(long orderID) {
        return ordersrepos.findById(orderID)
                .orElseThrow(() -> new EntityNotFoundException("Order " + orderID + " was not found."));
    }

    @Override
    public List<Order> getCustAdvanceAmt(double amount) {
        return ordersrepos.findByAdvanceamountGreaterThan(amount);
    }

    @Override
    public Order save(Order order) {
        return ordersrepos.save(order);
    }


}
