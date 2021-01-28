package com.skankhunt220.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClients;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class UserAutoConfiguration {
	private final Environment env;

	@Bean
	public MongoDatabaseFactory mongodbFactory() {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(env.getProperty("spring.data.mongodb.uri")),
				env.getProperty("spring.data.mongodb.database"));
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongodbFactory());
	}
}