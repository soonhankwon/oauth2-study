package com.example.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Oath2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oath2Application.class, args);
    }

}
