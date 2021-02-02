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

    private final String USER_ID = "6017f35ee836b9276b0f5869";

    @Test
    public void postMethodTest() throws Exception {
        User user = User.builder().firstName("post").middleName("method").lastName("test").build();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/users/")
                .contentType("application/json").content(objectMapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getMethodTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + "6018fdd9a5d643439dd8e648")
                    .contentType("application/json"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
    }

    @Test
    public void getAllUsersMethodTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/allUsers")
                .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUserFailTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/")
                .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }
}