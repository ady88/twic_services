package com.adrian.twic_services_ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.adrian.twic_services_core", "com.adrian.twic_services_ui"})
public class TwicServicesUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwicServicesUiApplication.class, args);
    }
}
