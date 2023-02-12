package com.prueba.sprinter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprinterApplication {

	static final Logger LOGGER = LoggerFactory.getLogger(SprinterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SprinterApplication.class, args);
	}

}
