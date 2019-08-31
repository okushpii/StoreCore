package com.soft.storecore.storecore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.soft.storecore")
@EntityScan(value = "com.soft.storecore.core.entity")
public class StoreCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreCoreApplication.class, args);
	}

}
