package com.skankhunt220.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;
import org.springframework.util.Assert;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void createUser() {
        User user = User.builder().lastName("testGuy").build();

        Mockito.doReturn(User.builder().id("1234").lastName(user.getLastName()).build())
                .when(userRepository)
                .save(user);

        User createdByService = userService.create(user);
        assertNotEquals(user, createdByService);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void updateUser() {
        User newUser = new User("1234", "testGuy");

        Mockito.doReturn(newUser)
                .when(userRepository)
                .queryUpdateLastName(newUser.getId(), newUser.getLastName());

        User updateUser = userService.update(newUser.getId(), newUser);

        assertEquals(newUser.getId(), updateUser.getId());

        Assertions.assertThat(newUser.getLastName()).isEqualTo("testGuy");
        Mockito.verify(userRepository, Mockito.times(1)).queryUpdateLastName(newUser.getId(), newUser.getLastName());
    }

    @Test
    void updateUserFailTest() {
        User newUser = new User("1234", "testGuy");

        Mockito.doThrow(new NullPointerException())
                .when(userRepository)
                .queryUpdateLastName(newUser.getId(), newUser.getLastName());

        assertThrows(NullPointerException.class, () -> {
            userService.update(newUser.getId(), newUser);
        });
    }
}