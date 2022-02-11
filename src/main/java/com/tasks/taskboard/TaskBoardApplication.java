package com.tasks.taskboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class TaskBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskBoardApplication.class, args);
    }
}
