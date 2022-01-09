package com.carsale.application.exceptions;

public class BusinessSystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessSystemException(String message) {
		super(message);
	}
}
