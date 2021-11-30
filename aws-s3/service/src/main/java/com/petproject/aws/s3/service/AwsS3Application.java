package com.petproject.aws.s3.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(value = {"com.petproject.aws.s3"})
public class AwsS3Application {
    public static void main(String[] args) {
        SpringApplication.run(AwsS3Application.class, args);
    }
}
