package com.example.testcontainerssimple;


import java.io.File;
import java.util.List;

import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import com.example.testcontainerssimple.entities.Customer;
import com.example.testcontainerssimple.repository.CustomerRepository;
import com.intuit.karate.junit5.Karate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static com.example.testcontainerssimple.TestTestcontainersSimpleApplication.POSTGRES_14_9_ALPINE;

//@Testcontainers
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

//  @ClassRule
//  public static DockerComposeContainer environment =
//          new DockerComposeContainer(new File("docker/docker-compose-kafka.yml"))
////                  .withExposedService("redis_1", REDIS_PORT)
////                  .withExposedService("elasticsearch_1", ELASTICSEARCH_PORT)
//          ;

  @Karate.Test
  Karate shouldGetAllCustomers() {

    return Karate.run("classpath:features/customer.feature");
  }
}