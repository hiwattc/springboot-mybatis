package com.staroot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootTrainingMybatisApplication {

	private static final Logger logger = LoggerFactory.getLogger(BootTrainingMybatisApplication.class);
	
	public static void main(String[] args) {
		logger.debug("BootTrainingMybatisApplication start");
		SpringApplication.run(BootTrainingMybatisApplication.class, args);
	}

}

