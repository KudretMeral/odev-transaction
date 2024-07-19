package com.vehicle.microservice_transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="customAuditorAware")
@SpringBootApplication
public class MicroserviceTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTransactionApplication.class, args);
	}

}
