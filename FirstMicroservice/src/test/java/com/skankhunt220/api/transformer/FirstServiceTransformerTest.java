package com.skankhunt220.api.transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.skankhunt220.api.Dto.CurrentServiceUserDto;
import com.skankhunt220.entity.User;

@SpringBootTest
class FirstServiceTransformerTest {
    @Test
    void transformIntoCurrentServiceUserDtoTest() {
        assertEquals(CurrentServiceUserDto.class,
                FirstServiceTransformer.transformIntoCurrentServiceDto(new User()).getClass());
    }
    
    @Test
    void transformIntoUserTest() {
        assertEquals(User.class,
                FirstServiceTransformer.transformIntoUser(new CurrentServiceUserDto()).getClass());
    }
}