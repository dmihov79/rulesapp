package com.example.rulesapp.util;

import com.example.rulesapp.entities.Rule;
import com.example.rulesapp.repositories.RuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataBaseLoader implements CommandLineRunner {
    @Autowired
    RuleRepository ruleRepository;
    @Override
    public void run(String... args) throws Exception {
        if(ruleRepository.findAll().size() == 0)
            loadDb();
    }

    private void loadDb() {
        {
            Rule rule = new Rule();
            rule.setRuleName("Add rule");
            rule.setRule("Add rule with ruleName and rule to database.");
            ruleRepository.save(rule);
        }
        {
            Rule rule = new Rule();
            rule.setRuleName("Delete rule");
            rule.setRule("Delete rule with specific id.");
            ruleRepository.save(rule);
        }
        {
            Rule rule = new Rule();
            rule.setRuleName("Update rule");
            rule.setRule("Update rule with specific id. Get ruleName and rule from params.");
            ruleRepository.save(rule);
        }
    }
}
