package com.devhackarena.infrastructure.persistence.postgres.configuration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
@Import({PostgresProperties.class})
public class PostgresConfig {
  private static final String POSTGRES_DRIVER = "postgresql";

  @Bean
  public ConnectionFactory connectionFactory(PostgresProperties postgresProperties) {
    return ConnectionFactories.get(
        ConnectionFactoryOptions.builder()
            .option(DRIVER, POSTGRES_DRIVER)
            .option(HOST, postgresProperties.getHost())
            .option(PORT, postgresProperties.getPort())
            .option(USER, postgresProperties.getUser())
            .option(PASSWORD, postgresProperties.getPassword())
            .option(DATABASE, postgresProperties.getDatabase())
            .build());
  }

  @Bean
  public R2dbcRepositoryFactory r2dbcRepositoryFactory(DatabaseClient databaseClient) {
    return new R2dbcRepositoryFactory(
        databaseClient, new DefaultReactiveDataAccessStrategy(PostgresDialect.INSTANCE));
  }

  @Bean
  public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
    return DatabaseClient.builder()
        .connectionFactory(connectionFactory)
        .namedParameters(true)
        .build();
  }
}
