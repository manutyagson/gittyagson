package com.path.holidayairways.service;

import java.util.List;

import com.path.holidayairways.dto.FlightDto;
import com.path.holidayairways.entity.FlightMaster;

public interface FlightMasterService {
	
	public FlightMaster saveFlightMaster(FlightMaster flightMaster);
	
	public List<String> findByFlightNo(String flightNo);
	
	public List<FlightDto> getAllFlightDetailsFromAllTables();
	
	public FlightDto updateFlightDetails(FlightDto flightDto); 
	
	public List<FlightMaster> getDestination();
		
	

}
