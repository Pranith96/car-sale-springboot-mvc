package com.carsale.application.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsale.application.entity.BidingDetails;
import com.carsale.application.entity.Transaction;
import com.carsale.application.exceptions.BusinessSystemException;
import com.carsale.application.repository.BidingRepository;
import com.carsale.application.repository.CarRepository;
import com.carsale.application.repository.TransactionRepository;

@Service
@Transactional
public class BidingServiceImpl implements BidingService {

	private static final Logger logger = LogManager.getLogger(BidingServiceImpl.class);

	@Autowired
	BidingRepository bidingRepository;

	@Autowired
	TransactionRepository trasanctionRepository;

	@Autowired
	CarService carService;

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

	@Override
	public String saveTransactionDetails(Transaction transaction) {
		Transaction response = trasanctionRepository.save(transaction);
		String deactiveBidingResponse = updateBidingStatus(transaction.getCarNumber());
		String deactiveCarResponse = carService.updateCarStatus(transaction.getCarNumber());
		logger.info("removed all cars completed bidings:", deactiveCarResponse);
		logger.info("removed all unseccussfull bidings:", deactiveBidingResponse);
		if (response == null) {
			return "Transact failed to save";
		}
		return "Transact successfully saved. Your transaction Details are Transaction id: "
				+ response.getTransactionId() + " and car number: " + response.getCarNumber() + " and car Model: "
				+ response.getCarModel() + " and sold price: " + response.getCarBidingPrice();
	}
}
