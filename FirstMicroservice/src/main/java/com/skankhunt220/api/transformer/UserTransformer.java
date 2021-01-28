package com.skankhunt220.api.transformer;

import com.skankhunt220.api.Dto.UserDto;
import com.skankhunt220.entity.User;

public class UserTransformer {
	public static UserDto transform(User user) {
		return UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.middleName(user.getMiddleName())
				.lastName(user.getLastName())
				.build();	
	}
	
	public static User transform(UserDto user) {
		return User.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.middleName(user.getMiddleName())
				.lastName(user.getLastName())
				.build();
	}
}