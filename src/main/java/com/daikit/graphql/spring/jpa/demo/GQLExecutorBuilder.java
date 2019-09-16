package com.daikit.graphql.spring.jpa.demo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.daikit.graphql.config.GQLSchemaConfig;
import com.daikit.graphql.data.input.GQLListLoadConfig;
import com.daikit.graphql.data.output.GQLDeleteResult;
import com.daikit.graphql.data.output.GQLExecutionResult;
import com.daikit.graphql.data.output.GQLListLoadResult;
import com.daikit.graphql.datafetcher.GQLAbstractDeleteDataFetcher;
import com.daikit.graphql.datafetcher.GQLAbstractGetByIdDataFetcher;
import com.daikit.graphql.datafetcher.GQLAbstractGetListDataFetcher;
import com.daikit.graphql.datafetcher.GQLAbstractSaveDataFetcher;
import com.daikit.graphql.datafetcher.GQLCustomMethodDataFetcher;
import com.daikit.graphql.datafetcher.GQLDynamicAttributeRegistry;
import com.daikit.graphql.datafetcher.GQLPropertyDataFetcher;
import com.daikit.graphql.execution.GQLErrorProcessor;
import com.daikit.graphql.execution.GQLExecutor;
import com.daikit.graphql.execution.IGQLExecutorCallback;
import com.daikit.graphql.meta.GQLMetaModel;
import com.daikit.graphql.spring.jpa.demo.entity.AbstractEntity;
import com.daikit.graphql.spring.jpa.service.IEntityService;

import graphql.schema.DataFetcher;

/**
 * Builder for {@link GQLExecutor}
 *
 * @author Thibaut Caselli
 */
@Component
public class GQLExecutorBuilder {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private GQLSchemaConfig schemaConfig;
	@Autowired
	private GQLErrorProcessor gqlErrorProcessor;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private IEntityService entityService;

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	// PUBLIC METHODS
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

	/**
	 * Build the {@link GQLExecutor}
	 *
	 * @return the built {@link GQLExecutor}
	 */
	public GQLExecutor build() {
		logger.debug("START creating GraphQL executor...");
		final GQLExecutor gqlExecutor = new GQLExecutor(schemaConfig, createMetaModel(applicationContext),
				gqlErrorProcessor, createExecutorCallback(), createGetByIdDataFetcher(), createListDataFetcher(),
				createSaveDataFetcher(), createDeleteDataFetcher(), createCustomMethodDataFetcher(),
				createPropertyDataFetchers());
		logger.debug("END creating GraphQL executor");
		return gqlExecutor;
	}

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	// PRIVATE UTILS
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

	private GQLMetaModel createMetaModel(ApplicationContext applicationContext) {
		return new GQLMetaModelBuilder().build(applicationContext);
	}

	private IGQLExecutorCallback createExecutorCallback() {
		return new IGQLExecutorCallback() {
			@Override
			public void onAfterExecute(final graphql.ExecutionInput executionInput,
					final GQLExecutionResult executionResult) {
				logger.debug("After execution with input : " + executionInput + " and result : " + executionResult);
			}
		};
	}

	private DataFetcher<?> createGetByIdDataFetcher() {
		return new GQLAbstractGetByIdDataFetcher() {

			@SuppressWarnings("unchecked")
			@Override
			protected Object getById(final Class<?> entityClass, final String id) {
				return entityService.findById((Class<AbstractEntity>) entityClass, Long.valueOf(id));
			}

		};
	}

	private DataFetcher<GQLListLoadResult> createListDataFetcher() {
		return new GQLAbstractGetListDataFetcher() {

			@Override
			protected GQLListLoadResult getAll(final Class<?> entityClass, final GQLListLoadConfig listLoadConfig) {
				return entityService.findAll(entityClass, listLoadConfig);
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Object getById(final Class<?> entityClass, final String id) {
				return entityService.findById((Class<AbstractEntity>) entityClass, Long.valueOf(id));
			}

		};
	}

	private DataFetcher<?> createSaveDataFetcher() {
		return new GQLAbstractSaveDataFetcher<Object>() {

			@Override
			protected void save(final Object entity) {
				entityService.save(entity);
			}

			@Override
			protected Object getOrCreateAndSetProperties(final Class<?> entityClass,
					final GQLDynamicAttributeRegistry dynamicAttributeRegistry,
					final Map<String, Object> fieldValueMap) {
				return entityService.findOrCreateAndSetProperties(entityClass, dynamicAttributeRegistry, fieldValueMap);
			}
		};
	}

	private DataFetcher<GQLDeleteResult> createDeleteDataFetcher() {
		return new GQLAbstractDeleteDataFetcher() {
			@Override
			protected void delete(final Class<?> entityClass, final String id) {
				entityService.delete(entityClass, Long.valueOf(id));
			}
		};
	}

	private DataFetcher<?> createCustomMethodDataFetcher() {
		return new GQLCustomMethodDataFetcher();
	}

	private List<GQLPropertyDataFetcher<?>> createPropertyDataFetchers() {
		return Collections.emptyList();
	}

}
