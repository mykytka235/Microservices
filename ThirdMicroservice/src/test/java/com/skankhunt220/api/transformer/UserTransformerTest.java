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
        User user = UserTransformer.transformIntoUser(new CurrentServiceUserDto());
        assertEquals(User.class, user.getClass());
    }

    @Test
    void transformIntoCurrentServiceUserDto() {
        CurrentServiceUserDto dto = UserTransformer.transformIntoCurrenServiceDto(new User());
        assertEquals(CurrentServiceUserDto.class, dto.getClass());
    }
}