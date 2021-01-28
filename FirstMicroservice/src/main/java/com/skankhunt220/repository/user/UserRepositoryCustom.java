package com.skankhunt220.repository.user;

import com.skankhunt220.entity.User;

public interface UserRepositoryCustom {
	User updateUserFirstName(String id, String firstName);
}
