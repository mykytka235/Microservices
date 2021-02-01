package com.skankhunt220.repository.user;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.skankhunt220.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom{
	private final MongoTemplate mongoTemplate;
	
	@Override
	public User updateUserFirstName(String id, String firstName) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.findAndModify(query, Update.update("firstName", firstName), User.class);
		return mongoTemplate.findById(id, User.class);
	}
}