package com.path.holidayairways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.path.holidayairways.entity.FlightDesc;

public interface FlightDescRepository extends JpaRepository<FlightDesc,String>{
	
	@Query(value="SELECT DISTINCT CATEGORY FROM FLIGHT_DESC",nativeQuery=true)
	public List<String> findByFlightCategory(String ctegory);

}
