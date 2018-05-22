package com.yzz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableZuulProxy
@SpringBootApplication
public class SprbtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprbtApplication.class, args);
    }
}
