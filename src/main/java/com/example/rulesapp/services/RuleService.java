package com.example.rulesapp.services;

import java.util.List;
import com.example.rulesapp.entities.Rule;
import com.example.rulesapp.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {
    @Autowired
    RuleRepository ruleRepository;

    public Rule getRuleById(Long id) {
        return ruleRepository.findById(id).get();
    }

    public Rule createRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    public Rule updateRule(Rule entity) {
        return ruleRepository.save(entity);
    }

    public void deleteRuleById(Long id) {
        ruleRepository.deleteById(id);
    }
}
