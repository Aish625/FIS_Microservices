package com.fis.zulugateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableZuul
@SpringBootApplication
public class ZuluGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuluGatewayApplication.class, args);
	}

}
