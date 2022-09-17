package com.ifsuldeminas.salems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SaleMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleMsApplication.class, args);
	}

}
