package com.maryanto.dimas.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WebfluxExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxExampleApplication.class, args);
    }

}
