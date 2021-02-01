package com.skankhunt220.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.skankhunt220.api.Dto.CurrentServiceUserDto;
import com.skankhunt220.entity.User;
import com.skankhunt220.service.UserService;

@SpringBootTest
class UserControllerTest {
    @Autowired
    UserController controller;
    @MockBean
    UserService service;
 
    @Test
    void createUserTest() {
        CurrentServiceUserDto dto = new CurrentServiceUserDto();       
        Mockito.doReturn(new User())
                .when(service)
                .create(ArgumentMatchers.any(User.class));
        
        assertEquals(CurrentServiceUserDto.class, controller.create(dto).getClass());
    }
    
    @Test
    void updateUserTest() {
        CurrentServiceUserDto dto = new CurrentServiceUserDto();
        Mockito.doReturn(new User())
                .when(service)
                .create(ArgumentMatchers.any(User.class));
        
        assertEquals(CurrentServiceUserDto.class, controller.create(dto).getClass());
    }
}
