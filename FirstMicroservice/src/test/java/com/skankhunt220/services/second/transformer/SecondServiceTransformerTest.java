package com.skankhunt220.services.second.transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.skankhunt220.entity.User;
import com.skankhunt220.services.second.dto.SecondServiceDto;

class SecondServiceTransformerTest {

    @Test
    void transformIntoSecondServiceDtoTest() {
        assertEquals(SecondServiceDto.class,
                SecondServiceTransformer.transformIntoSecondServiceDto(new User()).getClass());
    }
}