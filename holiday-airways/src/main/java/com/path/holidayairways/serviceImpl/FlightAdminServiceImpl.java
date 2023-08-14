package com.path.holidayairways.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.path.holidayairways.entity.FlightAdmin;
import com.path.holidayairways.repo.FlightAdminRepository;
import com.path.holidayairways.service.FlightAdminService;

@Service
public class FlightAdminServiceImpl implements FlightAdminService {

	@Autowired
	private FlightAdminRepository flightAdminRepository;
	
	@Override
	public FlightAdmin saveFlightAdmin(FlightAdmin flightAdmin) {
		return flightAdminRepository.save(flightAdmin);
	}

	@Override
	public FlightAdmin findByEmailAddressAndPassword(String emailAddress, String password) {
		return flightAdminRepository.findByEmailAddressAndPassword(emailAddress, password);
	}

	@Override
	public List<FlightAdmin> findByFirstName() {
		return flightAdminRepository.findAll();
	}

	@Override
	public List<FlightAdmin> findByLastName() {
		return flightAdminRepository.findAll();
	}

	@Override
	public List<FlightAdmin> findByEmailAddress() {
		return flightAdminRepository.findAll();
	}

	@Override
	public List<FlightAdmin> findByRegisterAs() {
		return flightAdminRepository.findAll();
	}

	@Override
	public FlightAdmin findEmployeeById(int id) {
		
		Optional<FlightAdmin> optional=flightAdminRepository.findById(id);
		
		FlightAdmin flightAdmin=null;
		
		if(optional.isPresent()) {
			flightAdmin=optional.get();
		}
		
		else {
			throw new RuntimeException("Invalid admin");
		}
		
		return flightAdmin;
	}
	
	




}
