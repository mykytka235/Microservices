package com.skankhunt220.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skankhunt220.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerIntTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUserTest() throws Exception {
        User user = User.builder().lastName("test").build();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/users/")
                .contentType("application/json").content(objectMapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
    @Test
    void updateUserTest() throws Exception{
        User user = User.builder().lastName("test2").build();
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/users/" + "6018fdd9a5d643439dd8e648")
                .contentType("application/json").content(objectMapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}