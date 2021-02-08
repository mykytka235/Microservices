package com.skankhunt220.api.transformer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.skankhunt220.api.Dto.CurrentServiceUserDto;
import com.skankhunt220.entity.User;

@SpringBootTest
class UserTransformerTest {

    @Test
    void transformIntoUserTest() {
        CurrentServiceUserDto dto = new CurrentServiceUserDto("123", "transformerTest");
        assertEquals("transformerTest", UserTransformer.transformIntoUser(dto).getLastName());
    }

    @Test
    void transformIntoCurrentServiceUserDtoTest() {
        User user = new User("123", "transformerTest");
        assertEquals("transformerTest", UserTransformer.transformIntoCurrenServiceDto(user).getLastName());
    }
}