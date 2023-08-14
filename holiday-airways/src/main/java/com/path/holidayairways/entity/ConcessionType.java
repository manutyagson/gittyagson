package com.path.holidayairways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Concession_Type")
public class ConcessionType {
	
	@Id
	@Column(name="ConcessionType")
	private String concessionType;
	
	public ConcessionType() {
		
	}

	
	public ConcessionType(String concessionType) {
		this.concessionType = concessionType;
	}


	public String getConcessionType() {
		return concessionType;
	}

	public void setConcessionType(String concessionType) {
		this.concessionType = concessionType;
	}
	
	

}
