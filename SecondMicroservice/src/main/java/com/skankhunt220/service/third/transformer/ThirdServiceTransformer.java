package com.skankhunt220.service.third.transformer;

import com.skankhunt220.entity.User;
import com.skankhunt220.service.third.dto.ThirdServiceDto;

public class ThirdServiceTransformer {
    public static ThirdServiceDto transformIntoThirdUserDto(User user) {
        return ThirdServiceDto.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .build();
    }
}
