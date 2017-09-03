package com.adrian.twic_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.adrian.twic_services"})
public class TwicServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwicServicesApplication.class, args);
	}
}
