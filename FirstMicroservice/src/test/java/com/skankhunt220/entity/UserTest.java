package com.skankhunt220.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {
    
    @Test
    void UserCreationTest() {
        User user = new User("2132", "1", "2", "3");
        Assertions.assertThat(user).extracting("firstName", "middleName", "lastName")
                                    .contains("1", "2", "3");
    }
}
