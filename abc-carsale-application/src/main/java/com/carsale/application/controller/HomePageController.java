package com.carsale.application.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomePageController {

	private static final Logger logger = LogManager.getLogger(HomePageController.class);

	@GetMapping("/page")
	public ModelAndView loadHomePage() {
		logger.info("In Home page controller");
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

	@GetMapping("/about-us")
	public ModelAndView loadAboutUsPage() {
		logger.info("In Home page controller");
		ModelAndView model = new ModelAndView();
		model.setViewName("about_us");
		return model;
	}
}
