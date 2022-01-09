package com.carsale.application.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsale.application.entity.BidingDetails;
import com.carsale.application.exceptions.BusinessSystemException;
import com.carsale.application.repository.BidingRepository;

@Service
@Transactional
public class BidingServiceImpl implements BidingService {

    private static final Logger logger = LogManager.getLogger(BidingServiceImpl.class);

	@Autowired
	BidingRepository bidingRepository;

	@Override
	public String saveBidingDetails(BidingDetails bidingDetails) {
		logger.info("In service class before save Biding Details");
		BidingDetails response = bidingRepository.save(bidingDetails);
		logger.info("In service class after save Biding Details");
		if (response == null) {
			return "Biding Details not saved";
		}
		return "Your biding Details Saved succesfully. We will reachout to you Shortly";
	}

	@Override
	public List<BidingDetails> getAllBidingDetails() {
		logger.info("In service class before listing all biding details");
		List<BidingDetails> response = bidingRepository.findAll().stream()
				.filter(biding -> biding.getStatus().equals("ACTIVE")).collect(Collectors.toList());
		logger.info("In service class after listing all biding details");
		if (null == response || response.isEmpty()) {
			throw new BusinessSystemException("No Biding Details Available");
		}
		return response;
	}

	@Override
	public String updateBidingStatus(String carNumber) {
		logger.info("In service class before deactivating biding");
		String inActiveBidingStatus = "INACTIVE";
		bidingRepository.updateBidingStatus(carNumber, inActiveBidingStatus);
		logger.info("In service class after deactivating biding");
		return "Deactivated Appointment Succesfully";
	}

	@Override
	public List<BidingDetails> listAllBidingDetailsForUserName(String userName) {
		logger.info("In service class before listing all biding details for UserName");
		List<BidingDetails> response = bidingRepository.findAllByUserName(userName).stream()
				.filter(biding -> biding.getStatus().equals("ACTIVE")).collect(Collectors.toList());
		logger.info("In service class after listing all biding details for UserName");
		if (null == response || response.isEmpty()) {
			throw new BusinessSystemException("No Biding Details Available");
		}
		return response;
	}

}
