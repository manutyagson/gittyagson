package com.path.holidayairways.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.path.holidayairways.entity.PassengerDetails;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails,Integer>{

}
