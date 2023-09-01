package com.bimal.feature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class FeatureFlagDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureFlagDemoApplication.class, args);
	}

}
