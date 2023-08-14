package com.path.holidayairways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.path.holidayairways.entity.ConcessionType;

public interface ConcessionTypeRepository extends JpaRepository<ConcessionType,String> {
    
	@Query(value="SELECT * FROM CONCESSION_TYPE",nativeQuery=true)
	public List<ConcessionType> getListOfConcessionType();
}
