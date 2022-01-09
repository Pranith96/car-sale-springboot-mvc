package com.carsale.application.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carsale.application.dto.UserUpdateDto;
import com.carsale.application.entity.Contact;
import com.carsale.application.entity.User;
import com.carsale.application.exceptions.BusinessSystemException;
import com.carsale.application.repository.ContactRepository;
import com.carsale.application.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public String registerUserDetails(User user) {
		logger.info("In service class before save user Details");
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setStatus("ACTIVE");
		User userResponse = userRepository.save(user);
		logger.info("In service class after save user Details");
		if (userResponse == null) {
			return "Details not saved successfully";
		}

		return "User Details Saved Successfully";
	}

	public List<User> getAllUsers() {
		logger.info("In service class before fetch user Details");
		List<User> userResponse = userRepository.findAll();
		logger.info("In service class after fetch user Details");
		if (null == userResponse || userResponse.isEmpty()) {
			throw new BusinessSystemException("No Users Available");
		}
		return userResponse;
	}

	public String UpdateUser(UserUpdateDto user) {
		logger.info("In service class before update user Details");
		Optional<User> userResponse = userRepository.findByUserName(user.getUserName());
		if (!userResponse.isPresent()) {
			throw new BusinessSystemException("User Details Doesnot match with Existing records");
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
		logger.info("In service class after update user Details");
		return "Details Successfully updated";
	}

	@Override
	public User getUserProfile(Integer userId) {
		logger.info("In service class before fetch user Details");
		Optional<User> userResponse = userRepository.findById(userId);
		logger.info("In service class after fetch user Details");
		if (!userResponse.isPresent()) {
			throw new BusinessSystemException("User Details Doesnot match with Existing records");
		}
		return userResponse.get();
	}

	@Override
	public String contactUs(Contact contact) {
		logger.info("In service class before fetch contact Details");
		Contact response = contactRepository.save(contact);
		logger.info("In service class after fetch contact Details");
		if (response == null) {
			return "Enter Valid Details";
		}
		return "Your resopnse is saved in our records. Our Team will reachout you Soon";
	}
}
