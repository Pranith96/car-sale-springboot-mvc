package com.carsale.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	@Column(unique = true)
	private String carNumber;
	private String carModel;
	private String file;
	private double price;
	private String userName;
	private String registrationYear;
	private String status;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getfile() {
		return file;
	}

	public void setfile(String file) {
		this.file = file;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public Car(Integer carId, String carNumber, String carModel, String file, double price, String userName,
			String registrationYear, String status) {
		this.carId = carId;
		this.carNumber = carNumber;
		this.carModel = carModel;
		this.file = file;
		this.price = price;
		this.userName = userName;
		this.registrationYear = registrationYear;
		this.status = status;
	}

	public Car() {
	}

}
