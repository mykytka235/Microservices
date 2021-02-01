package com.skankhunt220.api.transformer;

import com.skankhunt220.api.Dto.CurrentServiceUserDto;
import com.skankhunt220.entity.User;

public class UserTransformer {
    public static CurrentServiceUserDto transformIntoCurrenServiceDto(User user) {
        return CurrentServiceUserDto.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .build();   
    }
    
    public static User transformIntoUser(CurrentServiceUserDto user) {
        return User.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .build();
    }
}
