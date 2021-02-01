package com.skankhunt220.services.second.transformer;

import com.skankhunt220.entity.User;
import com.skankhunt220.services.second.dto.SecondServiceDto;

public class SecondServiceTransformer {
    public static SecondServiceDto transformIntoSecondServiceDto(User user) {
        return SecondServiceDto.builder()
                .id(user.getId())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .build();   
    }
}
