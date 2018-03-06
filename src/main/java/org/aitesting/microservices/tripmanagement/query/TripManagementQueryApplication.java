package org.aitesting.microservices.tripmanagement.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class TripManagementQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripManagementQueryApplication.class, args);
	}
}
