package com.path.holidayairways.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Flight_Details")
public class FlightDetails {
	
	
	@Id
	@Column(name="Flight_No",length=7)
	private String flightNo;
	
	@Column(name="Day_of_flight",nullable=true,length=20)
	private String flightDay;
	
	@Column(name="Time_of_flight",nullable=true)
	private Date flightTime;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private FlightMaster flMaster;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightDay() {
		return flightDay;
	}

	public void setFlightDay(String flightDay) {
		this.flightDay = flightDay;
	}

	public Date getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}

	public FlightMaster getFlMaster() {
		return flMaster;
	}

	public void setFlMaster(FlightMaster flMaster) {
		this.flMaster = flMaster;
	}
	
	
	
	
	

}