package com.pidev.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.pidev.backend.Repository")

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BackendPidevApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPidevApplication.class, args);
    }

}
