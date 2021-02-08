package com.skankhunt220.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skankhunt220.api.controller.UserController;
import com.skankhunt220.entity.User;
import com.skankhunt220.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerIntTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private final String url = "/api/users/";
    private final String USER_ID = "601921e405f07450c8bbc837";

    @Test
    public void getMethodTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url + USER_ID)
                    .contentType("application/json"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
    }

    @Test
    public void getAllUsersMethodTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url + "allUsers")
                .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUserFailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }
}