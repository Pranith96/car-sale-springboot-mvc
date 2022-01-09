package com.carsale.application.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	private String carNumber;
	private String carModel;
	private double carBidingPrice;
	private String userName;
	@CreatedDate
	private LocalDateTime localDateTime;

	public Transaction(Integer transactionId, String carNumber, String carModel, double carBidingPrice, String userName,
			LocalDateTime localDateTime) {
		this.transactionId = transactionId;
		this.carNumber = carNumber;
		this.carModel = carModel;
		this.carBidingPrice = carBidingPrice;
		this.userName = userName;
		this.localDateTime = localDateTime;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getCarBidingPrice() {
		return carBidingPrice;
	}

	public void setCarBidingPrice(double carBidingPrice) {
		this.carBidingPrice = carBidingPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Transaction() {
	}

}
