package com.coviam.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Aditya.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.coviam.dao")
@ConditionalOnExpression("'${user.db}'=='mongo'")
public class MongoConfig {
}
