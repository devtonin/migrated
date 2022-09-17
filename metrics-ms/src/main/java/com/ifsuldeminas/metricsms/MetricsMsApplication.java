package com.ifsuldeminas.metricsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MetricsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsMsApplication.class, args);
	}

}
