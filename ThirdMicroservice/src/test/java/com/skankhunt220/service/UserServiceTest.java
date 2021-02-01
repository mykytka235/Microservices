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

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void createUser() {
        User user = User.builder().lastName("testGuy").build();

        Mockito.doReturn(new User(new ObjectId().toString(), user.getLastName()))
                .when(userRepository)
                .save(user);

        User createdByService = userService.create(user);

        assertNotEquals(user, createdByService);

        Assertions.assertThat(user.getLastName()).isEqualTo("testGuy");
        Assertions.assertThat(user.getId()).isNotEqualTo(createdByService.getId());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void updateUser() {
        User newUser = new User("1234", "testGuy");

        Mockito.doReturn(new User("1234", newUser.getLastName()))
                .when(userRepository)
                .queryUpdateLastName(newUser.getId(), newUser.getLastName());

        User updateUser = userService.update(newUser.getId(), newUser);

        assertEquals(newUser.getId(), updateUser.getId());

        Assertions.assertThat(newUser.getLastName()).isEqualTo("testGuy");
        Mockito.verify(userRepository, Mockito.times(1)).queryUpdateLastName(newUser.getId(), newUser.getLastName());
    }

    @Test
    void updateUserFail() {
        User newUser = new User("1234", "testGuy");

        Mockito.doThrow(new NullPointerException())
                .when(userRepository)
                .queryUpdateLastName(newUser.getId(), newUser.getLastName());
        assertThrows(NullPointerException.class, () -> {
            userService.update(newUser.getId(), newUser);
        });
        Mockito.verify(userRepository, Mockito.times(1)).queryUpdateLastName(newUser.getId(), newUser.getLastName());
    }
}