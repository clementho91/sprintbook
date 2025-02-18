package com.sprintbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sprintbook"})
@EnableJpaRepositories(basePackages = "com.sprintbook.repository")
@EntityScan(basePackages = {"com.sprintbook", "com.sprintbook.model"})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
