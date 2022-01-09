package com.carsale.application.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carsale.application.entity.BidingDetails;
import com.carsale.application.service.BidingService;

@RestController
@RequestMapping("/car")
public class BidingController {
	private static final Logger logger = LogManager.getLogger(BidingController.class);

	@Autowired
	BidingService bidingService;

	@GetMapping("/biding/page/{carNumber}/{carModel}")
	public ModelAndView loadBidingPage(@PathVariable("carNumber") String carNumber,
			@PathVariable("carModel") String carModel) {
		logger.info("In biding controller");
		ModelAndView model = new ModelAndView();
		BidingDetails bidingDetails = new BidingDetails();
		model.addObject("bidingDetails", bidingDetails);
		model.addObject("carNumber", carNumber);
		model.addObject("carModel", carModel);
		model.setViewName("biding_form");
		return model;
	}

	@PostMapping("/biding/check/{carNumber}/{carModel}")
	public ModelAndView saveBidingDetails(@ModelAttribute BidingDetails bidingDetails,
			@PathVariable("carNumber") String carNumber, @PathVariable("carModel") String carModel) {
		logger.info("In biding controller");
		bidingDetails.setCarNumber(carNumber);
		bidingDetails.setCarModel(carModel);
		bidingDetails.setStatus("ACTIVE");
		String response = bidingService.saveBidingDetails(bidingDetails);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("response", response);
		modelAndView.setViewName("successform");
		return modelAndView;
	}

	@GetMapping("/fetch/biding-details")
	public ModelAndView listAllBidingDetails() {
		logger.info("In biding controller");
		List<BidingDetails> response = bidingService.getAllBidingDetails();
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("bidinglist");
		return model;
	}

	@GetMapping("/biding/deactive/{carNumber}")
	public ModelAndView updateBidingStatus(@PathVariable("carNumber") String carNumber) {
		logger.info("In biding controller");
		String response = bidingService.updateBidingStatus(carNumber);
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("successform");
		return model;
	}

	@GetMapping("/get/user/biding-detials/{userName}")
	public ModelAndView listAllBidingDetailsForUserName(@PathVariable("userName") String userName) {
		logger.info("In biding controller");
		List<BidingDetails> response = bidingService.listAllBidingDetailsForUserName(userName);
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("viewbidingposts");
		return model;
	}
}
