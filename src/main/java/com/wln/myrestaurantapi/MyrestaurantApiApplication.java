package com.wln.myrestaurantapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan(basePackages = "com.wln.myrestaurantapi.domain.model")
@SpringBootApplication
public class MyrestaurantApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyrestaurantApiApplication.class, args);
    }

}
