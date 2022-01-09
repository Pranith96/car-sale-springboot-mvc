package com.carsale.application.exceptions;

import java.time.LocalDateTime;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessSystemException.class)
	public ModelAndView handleBusinessSystemException(BusinessSystemException ex, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setDescription("No Data Found or Empty");
		ModelAndView model = new ModelAndView();
		model.addObject("message", response.getMessage());
		model.addObject("description", response.getDescription());
		model.addObject("dateTime", response.getDateTime());
		model.setViewName("errorpage");
		return model;
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ModelAndView handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setDescription("User Details Incorrect");
		ModelAndView model = new ModelAndView();
		model.addObject("message", response.getMessage());
		model.addObject("description", response.getDescription());
		model.addObject("dateTime", response.getDateTime());
		model.setViewName("loginerrorpage");
		return model;
	}
	
	@ExceptionHandler(InternalAuthenticationServiceException.class)
	public ModelAndView handleInternalAuthenticationServiceException(InternalAuthenticationServiceException ex, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setDescription("User Details Incorrect. Please Enter Valid Credentails");
		ModelAndView model = new ModelAndView();
		model.addObject("message", response.getMessage());
		model.addObject("description", response.getDescription());
		model.addObject("dateTime", response.getDateTime());
		model.setViewName("loginerrorpage");
		return model;
	}

}