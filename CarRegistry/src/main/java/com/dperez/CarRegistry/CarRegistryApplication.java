package com.dperez.CarRegistry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class CarRegistryApplication {

	public static void main(String[] args) {

		log.info("RUNNING CAR REGISTRY APPLICATION");
		SpringApplication.run(CarRegistryApplication.class, args);

	}

}
