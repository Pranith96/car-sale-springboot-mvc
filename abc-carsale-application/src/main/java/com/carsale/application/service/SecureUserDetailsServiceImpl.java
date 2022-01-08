package com.carsale.application.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carsale.application.entity.User;
import com.carsale.application.repository.UserRepository;

@Service
public class SecureUserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LogManager.getLogger(SecureUserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		logger.info("in  userdetails service");
		Optional<User> storeDetails = userRepository.findByUserName(userName);

		if (storeDetails == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new SecureUserDetails(storeDetails.get());
	}
}
