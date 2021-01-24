package com.skankhunt220.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.skankhunt220.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {}
	