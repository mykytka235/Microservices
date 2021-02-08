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
    private final String url = "/api/users/";
    private final String USER_ID = "601921e405f07450c8bbc837";

    @Test
    void createUserTest() throws Exception {
        User user = User.builder().lastName("test").build();
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType("application/json").content(objectMapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
    @Test
    void updateUserTest() throws Exception{
        User user = User.builder().lastName("test2").build();
        mockMvc.perform(MockMvcRequestBuilders.put(url + USER_ID)
                .contentType("application/json").content(objectMapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}