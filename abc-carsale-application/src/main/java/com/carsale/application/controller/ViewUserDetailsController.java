package com.carsale.application.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.entity.User;
import com.carsale.application.service.UserService;

@RestController
@RequestMapping("/user")
public class ViewUserDetailsController {
	private static final Logger logger = LogManager.getLogger(ViewUserDetailsController.class);

	@Autowired
	UserService userService;

	@GetMapping("/get/allUsers")
	public ModelAndView listUsers() {
		logger.info("In view user controller");
		List<User> users = userService.getAllUsers();
		ModelAndView model = new ModelAndView();
		model.addObject("users", users);
		model.setViewName("userslist");
		return model;
	}

	@GetMapping("/get/profile/{userId}")
	public ModelAndView getUserProfile(@PathVariable("userId") Integer userId) {
		logger.info("In view user controller");
		User user = userService.getUserProfile(userId);
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("profile");
		return model;
	}
}
