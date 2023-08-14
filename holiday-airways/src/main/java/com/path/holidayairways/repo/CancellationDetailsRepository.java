package com.path.holidayairways.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.path.holidayairways.entity.CancellationDetails;

public interface CancellationDetailsRepository extends JpaRepository<CancellationDetails,Integer>{

}
