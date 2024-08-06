package com.devhackarena.infrastructure.persistence.postgres.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "database.postgres")
@Data
public class PostgresProperties {
  private String host;
  private String url;
  private Integer port;
  private String user;
  private String password;
  private String database;
}
