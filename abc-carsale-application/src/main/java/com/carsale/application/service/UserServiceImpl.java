package com.carsale.application.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carsale.application.dto.UserUpdateDto;
import com.carsale.application.entity.Contact;
import com.carsale.application.entity.User;
import com.carsale.application.repository.ContactRepository;
import com.carsale.application.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public String registerUserDetails(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setStatus("ACTIVE");
		User userResponse = userRepository.save(user);
		if (userResponse == null) {
			return "Details not saved successfully";
		}

		return "User Details Saved Successfully";
	}

	public List<User> getAllUsers() {
		List<User> userResponse = userRepository.findAll();
		return userResponse;
	}

	public String UpdateUser(UserUpdateDto user) {
		Optional<User> userResponse = userRepository.findByUserName(user.getUserName());
		if (!userResponse.isPresent()) {
			throw new RuntimeException("User Details Doesnot match with Existing records");
		}

		if (user.getUserName() != null && !user.getUserName().isEmpty()) {
			userResponse.get().setUserName(user.getUserName());
		}
		if (user.getEmailId() != null && !user.getEmailId().isEmpty()) {
			userResponse.get().setEmailId(user.getEmailId());
		}
		if (user.getMobileNumber() != null && !user.getMobileNumber().isEmpty()) {
			userResponse.get().setMobileNumber(user.getMobileNumber());
		}
		if (user.getName() != null && !user.getName().isEmpty()) {
			userResponse.get().setName(user.getName());
		}
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			userResponse.get().setPassword(encodedPassword);
		}
		userRepository.save(userResponse.get());
		return "Details Successfully updated";
	}

	@Override
	public User getUserProfile(Integer userId) {
		Optional<User> userResponse = userRepository.findById(userId);
		if (!userResponse.isPresent()) {
			throw new RuntimeException("User Details Doesnot match with Existing records");
		}
		return userResponse.get();
	}

	@Override
	public String contactUs(Contact contact) {
		Contact response = contactRepository.save(contact);
		if (response == null) {
			return "Enter Valid Details";
		}
		return "Your resopnse is saved in our records. Our Team will reachout you Soon";
	}
}
