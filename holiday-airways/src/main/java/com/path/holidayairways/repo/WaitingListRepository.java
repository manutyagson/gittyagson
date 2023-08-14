package com.path.holidayairways.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.path.holidayairways.entity.WaitingList;

public interface WaitingListRepository extends JpaRepository<WaitingList,Integer>{

}
