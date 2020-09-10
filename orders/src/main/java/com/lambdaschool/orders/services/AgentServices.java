package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.views.AgentCustCount;

import java.util.List;

public interface AgentServices {

    Agent findAgentByID(long agentID);

    List<AgentCustCount> findAgentCustCount();

    Agent save(Agent agent);
}
