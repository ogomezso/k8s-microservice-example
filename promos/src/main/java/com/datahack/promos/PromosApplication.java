package com.datahack.promos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories
@EnableSwagger2
public class PromosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromosApplication.class, args);
	}
}
