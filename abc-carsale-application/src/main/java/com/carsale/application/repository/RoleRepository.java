package com.carsale.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carsale.application.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByUserRole(String source);

}
