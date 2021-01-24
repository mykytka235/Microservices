package com.skankhunt220.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.skankhunt220.repository.user", mongoTemplateRef = "primaryMongoTemplate")
public class UserAutoConfiguration {
	@Primary
	@Bean(name = "primary")
	@ConfigurationProperties(prefix = "spring.data.mongodb")
	public MongoProperties getPrimary() {
		return new MongoProperties();
	}

	@Primary
	@Bean(name = "primaryMongoTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception {
		return new MongoTemplate(primaryFactory(getPrimary()));
	}

	@Primary
	@Bean
	public MongoDatabaseFactory primaryFactory(final MongoProperties mongo) throws Exception {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(mongo.getUri()), mongo.getDatabase());
	}
}
