package com.carsale.application.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.entity.User;
import com.carsale.application.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationControllerTest {

	@InjectMocks
	UserRegistrationController userRegistrationController;

	@Mock
	UserServiceImpl userServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadLoginPage() {
		ModelAndView mav = userRegistrationController.loadAddStorePage();
		Assert.assertEquals("registrationform", mav.getViewName());
	}

	@Test
	public void testRegisterUser() {
		User user = new User();
		Mockito.when(userServiceImpl.registerUserDetails(Mockito.any(User.class))).thenReturn(Mockito.anyString());
		ModelAndView mav = userRegistrationController.registerUser(user);
		Assert.assertEquals("registrationsuccess", mav.getViewName());
	}
}
