package com.carsale.application.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.carsale.application.entity.Car;

public interface CarService {
	
	List<Car> getCarDetails(String searchValue);

	List<Car> getAllCars();

	String updateCarStatus(String carNumber);

	String saveCarDetails(String carNumber, String carModel, double price, String userName, String registrationYear,
			MultipartFile file);

	List<Car> getCarList(String userName);

}