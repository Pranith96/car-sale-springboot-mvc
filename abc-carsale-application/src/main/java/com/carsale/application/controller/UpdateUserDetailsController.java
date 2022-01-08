package com.carsale.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.dto.UserUpdateDto;
import com.carsale.application.entity.User;
import com.carsale.application.service.UserService;

@RestController
@RequestMapping("/user")
public class UpdateUserDetailsController {

	@Autowired
	UserService userService;

	@GetMapping("/update/page")
	public ModelAndView loadUpdatePage() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("updateprofile");
		return model;
	}

	@PostMapping("/update/check")
	public ModelAndView updateUser(@ModelAttribute UserUpdateDto user) {
		String response = userService.UpdateUser(user);
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("successform");
		return model;
	}
}
