package com.example.rulesapp.controllers;

import java.util.List;
import com.example.rulesapp.entities.Rule;
import com.example.rulesapp.repositories.RuleRepository;
import com.example.rulesapp.services.RuleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class RuleController {
    @Autowired
    RuleService ruleService;
    private final RuleRepository ruleRepository;

    @PostMapping("/rules")
    public ResponseEntity<String> createRule(@RequestBody Rule rule) {
        if(rule == null)
            return ResponseEntity.status(422).body("Failure");

        ruleService.createRule(rule);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/rules")
    public ResponseEntity<List<Rule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @GetMapping("/rules/{id}")
    public ResponseEntity<Rule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.getRuleById(id));
    }

    @PutMapping("/rules/{id}")
    public ResponseEntity<String> updateRule(@PathVariable Long id, String ruleName, String rule) {
        Rule entity = new Rule();
        entity.setId(id);
        entity.setRuleName(ruleName);
        entity.setRule(rule);

        if(ruleService.getRuleById(id) == null)
            return ResponseEntity.status(422).body("Entity with this id does not exist.");

        ruleService.updateRule(entity);
        return ResponseEntity.ok("Success.");
    }

    @DeleteMapping("/rules/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {
        if(ruleService.getRuleById(id) == null)
            return ResponseEntity.status(422).body("Entity with this id does not exist.");

        ruleService.deleteRuleById(id);
        return ResponseEntity.ok("Success.");
    }

    @PostMapping("/execute")
    public ResponseEntity<String> executeRuleByIdAndParams(String [] params) {
        if(params == null)
            return ResponseEntity.status(422).body("Please add parametres");

        switch (params.length){
            case 0:
                return ResponseEntity.status(422).body("Please add parametres");
            case 1:
                ruleService.deleteRuleById(Long.parseLong(params[0]));
                return ResponseEntity.ok("Rule deleted.");
            case 2:
                Rule rule1 = new Rule();
                rule1.setRuleName(params[0]);
                rule1.setRule(params[1]);
                ruleService.createRule(rule1);
                return ResponseEntity.ok("Rule created.");
            case 3:
                Rule rule2 = ruleService.getRuleById(Long.parseLong(params[0]));

                if(rule2 == null)
                    return ResponseEntity.status(422).body("Cannot update rule with non existent id.");

                rule2.setRuleName(params[1]);
                rule2.setRule(params[2]);
                ruleService.updateRule(rule2);
                return ResponseEntity.ok("Rule updated.");
            default:
                return ResponseEntity.status(422).body("Number of parametres is not viable");
        }
    }
}
