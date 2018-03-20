package org.aitesting.microservices.tripmanagement.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@EnableRetry
@EnableDiscoveryClient
@SpringBootApplication
public class TripManagementQueryApplication {
    @Retryable(value = IllegalArgumentException.class, maxAttempts = 5)
    public static void main(String[] args) {
        SpringApplication.run(TripManagementQueryApplication.class, args);
    }
}
