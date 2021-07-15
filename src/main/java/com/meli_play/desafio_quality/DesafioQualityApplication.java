package com.meli_play.desafio_quality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DesafioQualityApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesafioQualityApplication.class, args);
    }

}
