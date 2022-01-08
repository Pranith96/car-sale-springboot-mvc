package com.carsale.application.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsale.application.entity.BidingDetails;
import com.carsale.application.repository.BidingRepository;

@Service
@Transactional
public class BidingServiceImpl implements BidingService {

	@Autowired
	BidingRepository bidingRepository;

	@Override
	public String saveBidingDetails(BidingDetails bidingDetails) {
		BidingDetails response = bidingRepository.save(bidingDetails);
		if (response == null) {
			return "Biding Details not saved";
		}
		return "Your biding Details Saved succesfully. We will reachout to you Shortly";
	}

	@Override
	public List<BidingDetails> getAllBidingDetails() {
		List<BidingDetails> response = bidingRepository.findAll().stream()
				.filter(biding -> biding.getStatus().equals("ACTIVE")).collect(Collectors.toList());
		if (null == response || response.isEmpty()) {
			throw new RuntimeException("Details not found");
		}
		return response;
	}
	
	@Override
	public String updateBidingStatus(String carNumber) {
		String inActiveBidingStatus = "INACTIVE";
		bidingRepository.updateBidingStatus(carNumber, inActiveBidingStatus);
		return "Deactivated Appointment Succesfully";
	}

	@Override
	public List<BidingDetails> listAllBidingDetailsForUserName(String userName) {
		List<BidingDetails> response = bidingRepository.findAllByUserName(userName).stream()
				.filter(biding -> biding.getStatus().equals("ACTIVE")).collect(Collectors.toList());
		if (null == response || response.isEmpty()) {
			throw new RuntimeException("Details not found");
		}
		return response;
	}

}
