package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;

public interface AgentServices {

    Agent findAgentByID(long agentID);

    Agent save(Agent agent);
}
