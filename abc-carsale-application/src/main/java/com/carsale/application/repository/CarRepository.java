package com.carsale.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carsale.application.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	@Query("Select c from Car as c	 where :searchValue IN(c.carModel,c.registrationYear)")
	List<Car> getCarDetails(String searchValue);

	@Modifying
	@Query("update Car c set c.status = :inActiveCarStatus where c.carNumber=:carNumber")
	void updateCarStatus(String carNumber, String inActiveCarStatus);

	List<Car> findAllByUserName(String userName);
}
