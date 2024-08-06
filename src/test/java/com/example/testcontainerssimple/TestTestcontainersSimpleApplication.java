package com.example.testcontainerssimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestTestcontainersSimpleApplication {

	public static final String POSTGRES_14_9_ALPINE = "postgres:14.9-alpine";

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse(POSTGRES_14_9_ALPINE));
	}

	public static void main(String[] args) {
		SpringApplication.from(DemoApp::main).with(TestTestcontainersSimpleApplication.class).run(args);
	}

}
