package com.path.holidayairways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.path.holidayairways.entity.FlightDetails;

public interface FlightDetailsRepository  extends JpaRepository<FlightDetails,String>{
	
	@Query(value="SELECT DISTINCT DAY_OF_FLIGHT FROM FLIGHT_DETAILS",nativeQuery=true)
	public List<String> findByFlightDays(String flightDays);

}
