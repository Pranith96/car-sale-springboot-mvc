package com.carsale.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomePageController {

	@GetMapping("/page")
	public ModelAndView loadLoginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminhome");
		return model;
	}
	
	
	@GetMapping("/about-us")
	public ModelAndView loadAboutUsPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("about_us");
		return model;
	}
}
