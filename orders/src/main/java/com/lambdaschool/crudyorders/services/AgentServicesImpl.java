package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices {

    @Autowired
    AgentRepository agentrepos;

    @Override
    public Agent findAgentByID(long agentID) {
        return agentrepos.findById(agentID)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + agentID + " was not found."));
    }

    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }
}
