package com.path.holidayairways.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.path.holidayairways.entity.FlightDetails;
import com.path.holidayairways.repo.FlightDetailsRepository;
import com.path.holidayairways.service.FlightDetailsService;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService{

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Override
	public FlightDetails saveFlightDetails(FlightDetails flightDetails) {
		return flightDetailsRepository.save(flightDetails);
	}

	@Override
	public List<String> findByFlightDetails(String flightDetails) {
		return flightDetailsRepository.findByFlightDays(flightDetails);
	}


	

}
