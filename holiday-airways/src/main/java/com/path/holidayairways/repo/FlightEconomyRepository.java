package com.path.holidayairways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.path.holidayairways.entity.FlightEconomy;

public interface FlightEconomyRepository extends JpaRepository<FlightEconomy,String>{
	
	@Query(value="SELECT ECONOMY FROM FLIGHT_ECONOMY",nativeQuery=true)
	public List<String> findEconomyList(String flightEconomy);
}
