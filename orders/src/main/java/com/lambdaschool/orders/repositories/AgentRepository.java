package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.views.AgentCustCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgentRepository extends CrudRepository<Agent, Long> {

    @Query(value = "SELECT a.agentcode, count(c.agentcode) count " +
            "FROM agents a LEFT JOIN customers c " +
            "ON a.agentcode = c.agentcode " +
            "GROUP BY c.agentcode", nativeQuery = true)
    List<AgentCustCount> findAgentCustCount();
}
