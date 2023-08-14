package com.path.holidayairways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.path.holidayairways.entity.FlightMaster;
import com.path.holidayairways.service.FlightMasterService;

@Controller
public class PassengerController {
	
	@Autowired
	private FlightMasterService flightMasterService;
	
	@GetMapping("/bookFlight")
	public String displayBookFlight() {
		
		List<FlightMaster> destination = flightMasterService.getDestination();
		System.out.println(destination.size());
		System.out.println(destination.toString());
		return "bookFlight";
		
	}
	
}
