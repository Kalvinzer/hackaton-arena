package com.devhackarena;

import com.devhackarena.config.DevHackArenaBackConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({DevHackArenaBackConfig.class})
public class HackathonArenaBackApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(HackathonArenaBackApplication.class)
						.web(WebApplicationType.REACTIVE)
						.run(args);
	}
}
