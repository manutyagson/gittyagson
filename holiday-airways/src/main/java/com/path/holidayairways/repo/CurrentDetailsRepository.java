package com.path.holidayairways.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.path.holidayairways.entity.CurrentDetails;

public interface CurrentDetailsRepository extends JpaRepository<CurrentDetails,String>{

}
