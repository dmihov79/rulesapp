package com.example.rulesapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RulesappApplicationIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllRulesEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rules"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateRuleEndpoint() throws Exception {
        String json = "{\n" +
                "\"ruleName\":\"test\",\n" +
                "    \"rule\":\"test\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/rules").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetRuleEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rules/202"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateRuleEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/rules/202?ruleName=test&rule=test"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteRuleEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/rules/202"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testExecuteRuleEndpoint() throws Exception {
        String [] params = new String[] {"201"};
        mockMvc.perform(MockMvcRequestBuilders.post("/execute?params=" + params[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
