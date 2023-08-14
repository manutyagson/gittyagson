package com.path.holidayairways.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.path.holidayairways.entity.FlightDesc;
import com.path.holidayairways.repo.FlightDescRepository;
import com.path.holidayairways.service.FlightDescService;

@Service
public class FlightDescServiceImpl implements FlightDescService{

	@Autowired
	private FlightDescRepository flightDescRepository;
	
	@Override
	public FlightDesc saveFlightDesc(FlightDesc flightDesc) {
		return flightDescRepository.save(flightDesc);
	}

	@Override
	public List<String> findByFlightCategory(String category) {
		return flightDescRepository.findByFlightCategory(category);
	}

}
