package com.example.testcontainerssimple;


import com.intuit.karate.junit5.Karate;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

public class CustomerControllerTest {

  @ClassRule // doens't work due to WSL2 Host mounted volumes
  public static DockerComposeContainer environment =
          new DockerComposeContainer(new File("docker/docker-compose-kafka.yml"))
          ;
//
  @BeforeAll
    public static void setUp() {
        environment.start();
    }
  @Karate.Test
  Karate shouldGetAllCustomers() {

    return Karate.run("classpath:features/customer.feature");
  }
  @AfterAll
  public static void tearDown() {
    environment.stop();
  }
}