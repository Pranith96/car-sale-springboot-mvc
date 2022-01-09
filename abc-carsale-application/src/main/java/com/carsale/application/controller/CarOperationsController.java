package com.carsale.application.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.entity.Car;
import com.carsale.application.service.CarService;

@RestController
@RequestMapping("/car")
public class CarOperationsController {

	private static final Logger logger = LogManager.getLogger(CarOperationsController.class);

	@Autowired
	CarService carService;

	@GetMapping("/details-save/page")
	public ModelAndView loadAddStorePage() {
		ModelAndView model = new ModelAndView();
		Car car = new Car();
		model.addObject("car", car);
		model.setViewName("carsale");
		return model;
	}

	@PostMapping(value = "/save/check", headers = ("content-type=multipart/*"))
	public ModelAndView saveCarDetails(@RequestParam("carNumber") String carNumber,
			@RequestParam("carModel") String carModel, @RequestParam("price") double price,
			@RequestParam("userName") String userName, @RequestParam("registrationYear") String registrationYear,
			@RequestParam("file") MultipartFile file) {
		logger.info("In car operations controller");
		String response = carService.saveCarDetails(carNumber, carModel, price, userName, registrationYear, file);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("response", response);
		modelAndView.setViewName("successform");
		return modelAndView;
	}

	@GetMapping("/search")
	public ModelAndView searchCar(@RequestParam("searchValue") String searchValue) {
		logger.info("In car operations controller");
		List<Car> response = carService.getCarDetails(searchValue);
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("searchview");
		return model;
	}

	@GetMapping("/fetch-details")
	public ModelAndView listCars() {
		logger.info("In car operations controller");
		List<Car> response = carService.getAllCars();
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("car_post_lists");
		return model;
	}

	@GetMapping("/get-details/{userName}")
	public ModelAndView getCarList(@PathVariable("userName") String userName) {
		logger.info("In car operations controller");
		List<Car> cars = carService.getCarList(userName);
		ModelAndView model = new ModelAndView();
		model.addObject("cars", cars);
		model.setViewName("viewcarposts");
		return model;
	}

	@GetMapping("/status/update/{carNumber}")
	public ModelAndView updateCarStatus(@PathVariable("carNumber") String carNumber) {
		logger.info("In car operations controller");
		String response = carService.updateCarStatus(carNumber);
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("successform");
		return model;
	}
}