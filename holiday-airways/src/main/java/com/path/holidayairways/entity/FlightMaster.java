package com.path.holidayairways.entity;

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
@Table(name="Flight_Master")
public class FlightMaster {
	
	@Id
	@Column(name="Flight_No",length=7)
	private String flightNo;
	
	@Column(name="Flight_Name",nullable=false,length=20)
	private String flightName;
	
	@Column(name="Source",nullable=false,length=20)
	private String source;
	
	@Column(name="Destination",nullable=false,length=20)
	private String destination;
	
	@Column(name="Total_capacity",nullable=false,columnDefinition="NUMBER")
	private Integer totalCapacity;
	
	@Column(name="Duration_Of_Flight",nullable=false,columnDefinition="NUMBER(4,2)")
	private Double flightDuration;  
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private FlightDesc flDesc;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Integer totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public Double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public FlightDesc getFlDesc() {
		return flDesc;
	}

	public void setFlDesc(FlightDesc flDesc) {
		this.flDesc = flDesc;
	}
	
	
	
	

}