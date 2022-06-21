package com.he.jwtlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JwtLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JwtLearnApplication.class, args);

        System.out.println(11);
    }

}
