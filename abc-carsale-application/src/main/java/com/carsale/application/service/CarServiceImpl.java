package com.carsale.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carsale.application.entity.Car;
import com.carsale.application.repository.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";

	@Autowired
	CarRepository carRepository;

	@Override
	public String saveCarDetails(String carNumber, String carModel, double price, String userName,
			String registrationYear, MultipartFile file) {
		Random number = new Random();
		Car car = new Car();
		car.setCarNumber(carNumber);
		car.setCarModel(carModel);
		car.setPrice(price);
		car.setRegistrationYear(registrationYear);
		car.setUserName(userName);
		car.setStatus("ACTIVE");
		String fileName = Math.abs(number.nextInt()) + car.getUserName()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
		Path fileNameAndPath = Paths.get(uploadDirectory, fileName);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		car.setfile(fileName);

		Car carResponse = carRepository.save(car);
		if (carResponse == null) {
			return "car details not saved";
		}
		return "car details saved Sucessfully";
	}

	@Override
	public List<Car> getCarDetails(String searchValue) {
		List<Car> response = carRepository.getCarDetails(searchValue).stream()
				.filter(status -> status.getStatus().equals("ACTIVE")).collect(Collectors.toList());
		if (null == response || response.isEmpty()) {
			throw new RuntimeException("Details not found for Search Key");
		}
		return response;
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> response = carRepository.findAll().stream().filter(car -> car.getStatus().equals("ACTIVE"))
				.collect(Collectors.toList());
		if (null == response || response.isEmpty()) {
			throw new RuntimeException("Details not found ");
		}
		return response;
	}

	@Override
	public String updateCarStatus(String carNumber) {
		String inActiveCarStatus = "INACTIVE";
		carRepository.updateCarStatus(carNumber, inActiveCarStatus);
		return "Deactivated Succesfully";
	}

	@Override
	public List<Car> getCarList(String userName) {
		List<Car> response = carRepository.findAllByUserName(userName).stream().filter(car -> car.getStatus().equals("ACTIVE"))
				.collect(Collectors.toList());
		if (null == response || response.isEmpty()) {
			throw new RuntimeException("Details not found ");
		}
		return response;
	}
}
