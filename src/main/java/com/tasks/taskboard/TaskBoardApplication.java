package com.tasks.taskboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.tasks.taskboard.repositories")
@ComponentScan(basePackages = {"com.tasks.taskboard.utils.mappers"})
@EntityScan(basePackages = {"com.tasks.taskboard.entities"})
@Configuration
public class TaskBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskBoardApplication.class, args);
    }
}
