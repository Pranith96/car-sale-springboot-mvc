package com.carsale.application.service;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.carsale.application.entity.Contact;
import com.carsale.application.entity.User;
import com.carsale.application.repository.ContactRepository;
import com.carsale.application.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	ContactRepository contactRepository;

	@Mock
	BCryptPasswordEncoder passwordEncoder;

	@Before
	public void setUp() {
		userRepository = mock(UserRepository.class);
		contactRepository = mock(ContactRepository.class);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegisterUserDetails() {
		User user = new User();
		user.setUserId(1);
		user.setEmailId("abcde@gmail.com");
		user.setName("ABCD");
		user.setPassword("Test");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		String userslist = userServiceImpl.registerUserDetails(user);
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setUserId(1);
		user.setEmailId("abcde@gmail.com");
		user.setName("ABCD");
		user.setPassword("Test");
		users.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(users);
		List<User> userslist = userServiceImpl.getAllUsers();
		Assert.assertEquals(1, userslist.size());
	}

	@Test
	public void testContactUs() {
		Contact contact = new Contact();
		Mockito.when(contactRepository.save(contact)).thenReturn(contact);
		String contactResponse = userServiceImpl.contactUs(contact);
	}
	
	@Test
	public void testGetUserProfile() {
		User user = new User();
		user.setUserId(1);
		user.setEmailId("abcde@gmail.com");
		user.setName("ABCD");
		user.setPassword("Test");
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		User userResponse = userServiceImpl.getUserProfile(user.getUserId());
	}

	
}
