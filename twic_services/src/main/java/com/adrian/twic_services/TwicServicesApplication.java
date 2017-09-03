package com.adrian.twic_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.adrian.twic_services", "com.adrian.twic_services_core"})
public class TwicServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwicServicesApplication.class, args);
    }
}
