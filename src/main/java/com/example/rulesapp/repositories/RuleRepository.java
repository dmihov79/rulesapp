package com.example.rulesapp.repositories;

import com.example.rulesapp.entities.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, String> {
}
