package com.example.rulesapp.services;

import com.example.rulesapp.entities.Rule;
import com.example.rulesapp.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {
    @Autowired
    RuleRepository ruleRepository;
    public Rule getRuleById(String id) {
        return ruleRepository.getById(id);
    }
}
