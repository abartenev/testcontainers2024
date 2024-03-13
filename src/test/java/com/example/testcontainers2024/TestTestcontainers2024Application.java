package com.example.testcontainers2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

@TestConfiguration(proxyBeanMethods = false)
public class TestTestcontainers2024Application {

    @Bean
    @ServiceConnection
    DockerComposeContainer<?> container() {
        return new DockerComposeContainer<>(new File("docker/docker-compose.yaml")).withLocalCompose(true);
    }

    public static void main(String[] args) {
        SpringApplication.from(Testcontainers2024Application::main).with(TestTestcontainers2024Application.class).run(args);
    }

}
