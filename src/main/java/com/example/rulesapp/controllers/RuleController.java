package com.example.rulesapp.controllers;

import com.example.rulesapp.entities.Rule;
import com.example.rulesapp.services.RuleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class RuleController {
    @Autowired
    RuleService ruleService;
    @GetMapping("/rules/{id}")
    public ResponseEntity<Rule> getRule(@PathVariable String id) {
        if(!id.isEmpty())
            return ResponseEntity.ok(ruleService.getRuleById(id));
        else
            return ResponseEntity.status(422).build();
    }
}
