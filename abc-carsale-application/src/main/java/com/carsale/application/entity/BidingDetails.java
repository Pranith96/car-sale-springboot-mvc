package com.carsale.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BidingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bidingId;
	@Column(unique = true)
	private String carNumber;
	private String carModel;
	private double carBidingPrice;
	@Column(unique = true)
	private String userName;
	private String date;
	private String status;

	public BidingDetails() {
	}

	public BidingDetails(Integer bidingId, String carNumber, String carModel, double carBidingPrice, String userName,
			String date, String status) {
		super();
		this.bidingId = bidingId;
		this.carNumber = carNumber;
		this.carModel = carModel;
		this.carBidingPrice = carBidingPrice;
		this.userName = userName;
		this.date = date;
		this.status = status;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBidingId() {
		return bidingId;
	}

	public void setBidingId(Integer bidingId) {
		this.bidingId = bidingId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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

}
