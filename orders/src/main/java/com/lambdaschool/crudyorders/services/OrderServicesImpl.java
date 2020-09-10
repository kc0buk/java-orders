package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.models.Payment;
import com.lambdaschool.crudyorders.repositories.CustomerRepository;
import com.lambdaschool.crudyorders.repositories.OrderRepository;
//import com.lambdaschool.crudyorders.views.CustomerAdvanceAmt;
import com.lambdaschool.crudyorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices {

    @Autowired
    OrderRepository ordersrepos;

    @Autowired
    CustomerRepository custrepos;

    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public Order findOrderByID(long orderID) {
        return ordersrepos.findById(orderID)
                .orElseThrow(() -> new EntityNotFoundException("Order " + orderID + " was not found."));
    }

    @Override
    public List<Order> getCustAdvanceAmt(double amount) {
        return ordersrepos.findByAdvanceamountGreaterThan(amount);
    }

    @Transactional
    @Override
    public Order save(Order order) {

        Order newOrder = new Order();

        if (order.getOrdnum() != 0) {
            ordersrepos.findById(order.getOrdnum())
                    .orElseThrow(() -> new EntityNotFoundException("Order ID " + order.getOrdnum() + " was not found" +
                            "."));
            newOrder.setOrdnum(order.getOrdnum());
        }

        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setOrderdescription((order.getOrderdescription()));
        newOrder.setCustomer(custrepos.findById(order.getCustomer().getCustcode())
            .orElseThrow(() -> new EntityNotFoundException("Customer " + order.getCustomer().getCustcode() + " was " +
                    "not found."))
        );
        newOrder.getPayments().clear();
        for (Payment p : order.getPayments()) {
            Payment newPayment = paymentrepos.findById(p.getPaymentid())
                    .orElseThrow(() -> new EntityNotFoundException("Payment ID " + p.getPaymentid() + " was not " +
                            "found."));
            newOrder.getPayments().add(newPayment);
        }

        return ordersrepos.save(newOrder);
    }


}
