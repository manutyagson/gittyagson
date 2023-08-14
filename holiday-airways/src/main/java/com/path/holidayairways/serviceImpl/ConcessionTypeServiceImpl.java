package com.path.holidayairways.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.path.holidayairways.entity.ConcessionType;
import com.path.holidayairways.repo.ConcessionTypeRepository;
import com.path.holidayairways.service.ConcessionTypeService;

@Service
public class ConcessionTypeServiceImpl implements ConcessionTypeService{

	@Autowired
	private ConcessionTypeRepository concessionTypeRepository;
	
	@Override
	public List<ConcessionType> getListOfConcessionType() {
		return concessionTypeRepository.findAll();
	}
  
}
