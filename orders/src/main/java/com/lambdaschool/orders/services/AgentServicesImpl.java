package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentRepository;
import com.lambdaschool.orders.views.AgentCustCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    @Override
    public List<AgentCustCount> findAgentCustCount() {
        List<AgentCustCount> removedList = agentrepos.findAgentCustCount();
//        List<AgentCustCount> list = new ArrayList<>();
        for (AgentCustCount a : removedList) {
            if (a.getCount() < 1) {
                agentrepos.deleteById(a.getAgentcode());
            }
        }
        return null;
    }
}
