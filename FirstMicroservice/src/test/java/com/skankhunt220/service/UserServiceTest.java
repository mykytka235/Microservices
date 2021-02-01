package com.skankhunt220.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService service;
    @MockBean
    private UserRepository repository;
    
    @Test
    void getAllUsersTest() {   
        List<User> usersFromDatabase = new ArrayList<User>();
        usersFromDatabase.add(new User());
        usersFromDatabase.add(new User());
        
        Mockito.doReturn(usersFromDatabase)
                .when(repository)
                .findAll();
        
        List<User> users = service.getAllUsers();     
        Assertions.assertThat(users).hasSize(2);
        
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }
}