package com.carsale.application.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
public class ViewUserDetailsControllerTest {

	@InjectMocks
	ViewUserDetailsController viewUserDetailsController;

	@Mock
	UserServiceImpl userServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListUsers() {
		List<User> users = new ArrayList<>();
		when(userServiceImpl.getAllUsers()).thenReturn(users);
		ModelAndView mav = viewUserDetailsController.listUsers();
		Assert.assertEquals("userslist", mav.getViewName());
	}

	@Test
	public void testGetUserProfile() {
		User user = new User();
		when(userServiceImpl.getUserProfile(Mockito.anyInt())).thenReturn(user);
		ModelAndView mav = viewUserDetailsController.getUserProfile(1);
		Assert.assertEquals("profile", mav.getViewName());
	}
}
