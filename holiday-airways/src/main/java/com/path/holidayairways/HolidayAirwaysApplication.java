package com.path.holidayairways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.path.holidayairways.entity.FlightEconomy;
import com.path.holidayairways.entity.RegisterAs;
import com.path.holidayairways.repo.ConcessionTypeRepository;
import com.path.holidayairways.repo.FlightEconomyRepository;
import com.path.holidayairways.repo.RegisterAsRepository;

@SpringBootApplication
public class HolidayAirwaysApplication implements CommandLineRunner{

	@Autowired
	private RegisterAsRepository registerAsRepository;
	
	@Autowired
	private FlightEconomyRepository flightEconomyRepository;
	
	@Autowired
	private ConcessionTypeRepository concessionTypeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HolidayAirwaysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		flightEconomyRepository.save(new FlightEconomy("BUS"));
		
//		concessionTypeRepository.save(new ConcessionType("Student Concession"));
	
	}

}
