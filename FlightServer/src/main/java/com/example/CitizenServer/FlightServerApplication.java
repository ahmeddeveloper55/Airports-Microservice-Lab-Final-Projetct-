package com.example.CitizenServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServerApplication.class, args);
	}

}
