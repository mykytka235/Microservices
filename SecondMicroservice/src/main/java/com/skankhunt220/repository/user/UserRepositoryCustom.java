package com.skankhunt220.repository.user;

import com.skankhunt220.entity.User;

public interface UserRepositoryCustom {
	User updateUserMiddleName(String id, String middleName);
}
