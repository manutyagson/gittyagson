package com.path.holidayairways.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.path.holidayairways.entity.Cancellation;

public interface CancellationRepository extends JpaRepository<Cancellation,Integer>{

}
