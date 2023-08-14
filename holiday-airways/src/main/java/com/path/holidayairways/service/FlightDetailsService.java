package com.path.holidayairways.service;

import java.util.List;

import com.path.holidayairways.entity.FlightDetails;

public interface FlightDetailsService {

	public FlightDetails saveFlightDetails(FlightDetails flightDetails);
	
	public List<String> findByFlightDetails(String flightDetails);
}
