package com.example.rulesapp;

import com.example.rulesapp.entities.Rule;
import com.example.rulesapp.repositories.RuleRepository;
import com.example.rulesapp.services.RuleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RulesappApplicationUnitTests {
	@Autowired
	RuleService ruleService;
	@Autowired
	private RuleRepository ruleRepository;

	@Test
	public void testCreateRule() {
		Rule rule = new Rule();
		rule.setRuleName("test");
		rule.setRule("test");

		Rule savedRule = ruleService.createRule(rule);

		Assertions.assertEquals(savedRule.getRuleName(), rule.getRule());
		Assertions.assertEquals(savedRule.getRule(), rule.getRule());
	}

	@Test
	public void testReadRule() {
		Rule rule = ruleService.getRuleById(1L);

		Assertions.assertNotNull(rule);
	}

	@Test
	public void testDeleteRule() {
		ruleService.deleteRuleById(1L);

		Assertions.assertNull(ruleService.getRuleById(1L));
	}

	@Test
	public void testUpdateRule() {
		Rule rule = ruleService.getRuleById(2L);

		rule.setRule("test");

		Rule savedRule = ruleService.updateRule(rule);

		Assertions.assertEquals(rule.getRule(), savedRule.getRule());
	}

}
