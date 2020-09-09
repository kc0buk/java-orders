package com.lambdaschool.crudyorders.repositories;

import com.lambdaschool.crudyorders.models.Order;
//import com.lambdaschool.crudyorders.views.CustomerAdvanceAmt;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

//    @Query(value = "SELECT c.custname name, o.ordnum ordernumber, o.advanceamount " +
//            "FROM orders o LEFT JOIN customers c " +
//            "ON o.custcode = c.custcode " +
//            "WHERE o.advanceamount > 0 " +
//            "GROUP BY name, ordernumber " +
//            "ORDER BY advanceamount DESC, name", nativeQuery = true)
//    List<Order> getCustAdvanceAmt();

    List<Order> findByAdvanceamountGreaterThan(double amount);
}
