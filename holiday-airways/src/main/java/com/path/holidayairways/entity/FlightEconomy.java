package com.path.holidayairways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flight_Economy")
public class FlightEconomy {
	
	@Id
	@Column(name="Economy")
	private String economy;
	
	public FlightEconomy() {
		
	}
	
	

	public FlightEconomy(String economy) {
		this.economy = economy;
	}



	public String getEconomy() {
		return economy;
	}

	public void setEconomy(String economy) {
		this.economy = economy;
	}

}
