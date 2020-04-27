package com.example.hzvita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HzvitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzvitaApplication.class,"--server.port=8686");
    }

}
