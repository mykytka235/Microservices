package com.skankhunt220.api.transformer;

import com.skankhunt220.api.Dto.UserDto;
import com.skankhunt220.entity.User;

public class Transformer {
	public static UserDto transform(User user, String id) {
		return UserDto.builder()
				.id(id)
				.middleName(user.getMiddleName())
				.lastName(user.getLastName())
				.build();	
	}
	public static User transform(UserDto user, String id) {
		return User.builder()
				.id(id)
				.middleName(user.getMiddleName())
				.lastName(user.getLastName())
				.build();	
	}
}