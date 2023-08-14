package com.path.holidayairways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.path.holidayairways.entity.FlightAdmin;

public interface FlightAdminRepository extends JpaRepository<FlightAdmin,Integer> {
	
	public FlightAdmin findByEmailAddressAndPassword(String emailAddress,String password);

}
