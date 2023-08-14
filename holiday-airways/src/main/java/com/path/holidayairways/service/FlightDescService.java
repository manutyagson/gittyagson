package com.path.holidayairways.service;

import java.util.List;

import com.path.holidayairways.entity.FlightDesc;

public interface FlightDescService {
	
	public FlightDesc saveFlightDesc(FlightDesc flightDesc);
	
	public List<String> findByFlightCategory(String category);

}
