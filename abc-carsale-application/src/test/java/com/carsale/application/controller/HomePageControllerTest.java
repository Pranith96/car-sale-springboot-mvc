package com.carsale.application.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HomePageControllerTest {

	@InjectMocks
	HomePageController homePageController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadHomePage() {
		ModelAndView mav = homePageController.loadHomePage();
		Assert.assertEquals("home", mav.getViewName());
	}

	@Test
	public void testLoadAboutUsPage() {
		ModelAndView mav = homePageController.loadAboutUsPage();
		Assert.assertEquals("about_us", mav.getViewName());
	}
}
