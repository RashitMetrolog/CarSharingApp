package com.petproject.car.sharing.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.petproject.car.sharing"})
public class CarSharingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarSharingApplication.class, args);
    }
}
