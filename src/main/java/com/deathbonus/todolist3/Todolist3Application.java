package com.deathbonus.todolist3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Todolist3Application {

    public static void main(String[] args) {
        SpringApplication.run(Todolist3Application.class, args);
    }

}
