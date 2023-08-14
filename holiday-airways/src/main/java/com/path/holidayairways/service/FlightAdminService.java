package com.path.holidayairways.service;

import java.util.List;

import com.path.holidayairways.entity.FlightAdmin;

public interface FlightAdminService{
	
	public FlightAdmin saveFlightAdmin(FlightAdmin flightAdmin);
	
	public FlightAdmin findByEmailAddressAndPassword(String emailAddress,String password);
	
	public List<FlightAdmin> findByFirstName();
	
	public List<FlightAdmin> findByLastName();
	
	public List<FlightAdmin> findByEmailAddress();
	
	public List<FlightAdmin> findByRegisterAs();
	
	public FlightAdmin findEmployeeById(int id);
	
	
	
}
