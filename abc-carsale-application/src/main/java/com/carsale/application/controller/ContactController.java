package com.carsale.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.entity.Contact;
import com.carsale.application.service.UserService;

@RestController
@RequestMapping("/home")
public class ContactController {

	@Autowired
	UserService userService;

	@GetMapping("/contact-us/page")
	public ModelAndView loadContactUsPage() {
		ModelAndView model = new ModelAndView();
		Contact contact = new Contact();
		model.addObject("contact", contact);
		model.setViewName("contact_us");
		return model;
	}

	@PostMapping("/contact-us/check")
	public ModelAndView contactUs(@ModelAttribute Contact contact) {
		String response = userService.contactUs(contact);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("response", response);
		modelAndView.setViewName("successform");
		return modelAndView;
	}
}
