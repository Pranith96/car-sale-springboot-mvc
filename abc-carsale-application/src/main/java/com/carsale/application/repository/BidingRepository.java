package com.carsale.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carsale.application.entity.BidingDetails;

@Repository
public interface BidingRepository extends JpaRepository<BidingDetails, Integer>{

	@Modifying
	@Query("update BidingDetails b set b.status = :inActiveBidingStatus where b.carNumber=:carNumber")
	void updateBidingStatus(String carNumber, String inActiveBidingStatus);

	List<BidingDetails> findAllByUserName(String userName);

}
