package com.devhackarena.config;

import com.devhackarena.IndexController;
import com.devhackarena.infrastructure.persistence.postgres.configuration.PostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PostgresConfig.class, IndexController.class})
public class DevHackArenaBackConfig {}
