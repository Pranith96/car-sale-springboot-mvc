package com.carsale.application;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carsale.application.service.CarServiceImpl;

@SpringBootApplication
public class AbcCarSaleApplication {

	public static void main(String[] args) {
		new File(CarServiceImpl.uploadDirectory).mkdir();
		SpringApplication.run(AbcCarSaleApplication.class, args);
	}

}
