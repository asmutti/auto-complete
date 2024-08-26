package com.asmutti.autocomplete.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AutoCompleteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAutoCompleteEndpoint() throws Exception {
        mockMvc.perform(get("/autocomplete")
                        .param("query", "j"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void testAutoCompleteEmptyRequest() throws Exception {
        mockMvc.perform(get("/autocomplete")
                        .param("query", ""))
                .andExpect(status().isBadRequest());
    }
}
