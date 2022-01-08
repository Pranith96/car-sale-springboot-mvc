package com.carsale.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carsale.application.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
