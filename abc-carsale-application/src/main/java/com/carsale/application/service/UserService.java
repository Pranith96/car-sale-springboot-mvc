package com.carsale.application.service;

import java.util.List;

import com.carsale.application.dto.UserUpdateDto;
import com.carsale.application.entity.Contact;
import com.carsale.application.entity.User;

public interface UserService {

	String registerUserDetails(User user);

	List<User> getAllUsers();

	String UpdateUser(UserUpdateDto user);

	User getUserProfile(Integer userId);

	String contactUs(Contact contact);
}
