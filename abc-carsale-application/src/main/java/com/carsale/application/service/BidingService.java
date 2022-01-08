package com.carsale.application.service;

import java.util.List;

import com.carsale.application.entity.BidingDetails;

public interface BidingService {

	String saveBidingDetails(BidingDetails bidingDetails);

	List<BidingDetails> getAllBidingDetails();

	String updateBidingStatus(String carNumber);

	List<BidingDetails> listAllBidingDetailsForUserName(String userName);

}
