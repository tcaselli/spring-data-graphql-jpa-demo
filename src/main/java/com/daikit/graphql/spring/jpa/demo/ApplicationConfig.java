package com.daikit.graphql.spring.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.daikit.graphql.execution.GQLExecutor;

/**
 * {@link ApplicationConfig} spring component
 * 
 * @author Thibaut Caselli
 */
@Configuration
public class ApplicationConfig {

	@Autowired
	private GQLExecutorBuilder gqlExecutorBuilder;

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	// INITIALIZATION METHODS
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

	/**
	 * Create GQL Executor bean
	 *
	 * @return the created {@link GQLExecutor}
	 */
	@Bean
	public GQLExecutor createExecutor() {
		return gqlExecutorBuilder.build();
	}
}
