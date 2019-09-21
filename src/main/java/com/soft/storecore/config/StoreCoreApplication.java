package com.soft.storecore.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.soft.storecore")
@EntityScan(value = "com.soft.storecore.core")
public class StoreCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreCoreApplication.class, args);
	}

}
