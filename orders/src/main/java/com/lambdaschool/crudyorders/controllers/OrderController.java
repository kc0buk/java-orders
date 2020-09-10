package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.OrderServices;
//import com.lambdaschool.crudyorders.views.CustomerAdvanceAmt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServices orderServices;

    // GET /orders/order/{id}
    // Returns the order and its customer with the given order number
    @GetMapping(value = "/order/{orderID}", produces = {"application/json"})
    public ResponseEntity<?> findOrderByID(@PathVariable long orderID) {
        Order o = orderServices.findOrderByID(orderID);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    // GET /orders/advanceamount
    // Returns all orders with their customers that have an advanceamount greater than 0.
    @GetMapping(value = "/advanceamount/{amount}", produces = {"application/json"})
    public ResponseEntity<?> getCustAdvanceAmt(@PathVariable double amount) {
        List<Order> list = orderServices.getCustAdvanceAmt(amount);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/advanceamount", produces = {"application/json"})
    public ResponseEntity<?> getCustAdvanceAmt() {
        List<Order> list = orderServices.getCustAdvanceAmt(0);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // POST /orders/order
    // Adds a new order to an existing customer
    @PostMapping(value = "/order", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewOrder(@Valid @RequestBody Order newOrder) {
        newOrder.setOrdnum(0);
        newOrder = orderServices.save(newOrder);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ordNum}")
                .buildAndExpand(newOrder.getOrdnum())
                .toUri();
        responseHeaders.setLocation(newOrderURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // PUT /orders/order/{ordnum}
    // Completely replaces the given order record
    @PutMapping(value = "/order/{ordnum}", consumes = {"application/json"}, produces = {"applicaiton/json"})
    public ResponseEntity<?> replaceOrder(@PathVariable long ordnum, @Valid @RequestBody Order updateOrder) {
        updateOrder.setOrdnum(ordnum);
        updateOrder = orderServices.save(updateOrder);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // DELETE /orders/order/{ordername}
    // Deletes the given order
}
