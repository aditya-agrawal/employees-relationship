package com.coviam.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Aditya.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.coviam.dao")
@EntityScan("com.coviam.model")
@ConditionalOnExpression("'${user.db}'=='postgres'")
public class JpaConfig {
}
