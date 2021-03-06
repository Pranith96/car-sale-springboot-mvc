package com.carsale.application.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.entity.User;
import com.carsale.application.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {
    private static final Logger logger = LogManager.getLogger(UserRegistrationController.class);

	@Autowired
	UserService userService;

	@GetMapping("/registration/page")
	public ModelAndView loadAddStorePage() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("registrationform");
		return model;
	}

	@PostMapping("/register/check")
	public ModelAndView registerUser(@ModelAttribute User user) {
		logger.info("In user register controller");
		String response = userService.registerUserDetails(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("response", response);
		modelAndView.setViewName("registrationsuccess");
		return modelAndView;
	}
}
