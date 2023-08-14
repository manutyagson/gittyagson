package com.path.holidayairways.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.path.holidayairways.dto.FlightDto;
import com.path.holidayairways.entity.FlightMaster;
import com.path.holidayairways.repo.FlightMasterRepository;
import com.path.holidayairways.service.FlightMasterService;

@Service
public class FlightMasterServiceImpl implements FlightMasterService {
	
	
	@Autowired
	private FlightMasterRepository flightMasterRepository;
	
	@Override
	public FlightMaster saveFlightMaster(FlightMaster flightMaster) {
		return flightMasterRepository.save(flightMaster);
	}

	@Override
	public List<String> findByFlightNo(String flightNo) {
		return flightMasterRepository.findByFlightNo(flightNo);
	}

	@Override
	public List<FlightDto> getAllFlightDetailsFromAllTables() {
		return flightMasterRepository.getAllFlightDetailsFromAllTables();
	}

	@Override
	public FlightDto updateFlightDetails(FlightDto flightDto) {
		return null;
	}

	@Override
	public List<FlightMaster> getDestination() {
		return flightMasterRepository.getDestination();
	}


}
