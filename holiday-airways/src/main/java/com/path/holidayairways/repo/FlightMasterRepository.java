package com.path.holidayairways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.path.holidayairways.dto.FlightDto;
import com.path.holidayairways.entity.FlightMaster;

public interface FlightMasterRepository extends JpaRepository<FlightMaster, String> {

	@Query(value = "SELECT FLIGHT_NO FROM FLIGHT_MASTER", nativeQuery = true)
	public List<String> findByFlightNo(String flightNo);

	@Query(value="SELECT * FROM FLIGHT_MASTER",nativeQuery=true)
	public List<FlightMaster> getFlightDetails();
	
	@Query(value="select flight_master.flight_no,flight_master.destination,flight_master.duration_of_flight,flight_master.flight_name,flight_master.source,flight_master.total_capacity,flight_desc.ending_seat_no,flight_desc.starting_seat_no,flight_desc.cost_of_ticket,flight_desc.category,flight_details.day_of_flight,flight_details.time_of_flight from flight_master inner join flight_desc on flight_master.flight_no=flight_desc.flight_no join flight_details on flight_details.flight_no=flight_desc.flight_no",nativeQuery=true)
	public List<FlightDto> getAllFlightDetailsFromAllTables();
	
	@Query(value="SELECT DESTINATION FROM FLIGHT_MASTER",nativeQuery = true)
	public List<FlightMaster> getDestination();
	

}