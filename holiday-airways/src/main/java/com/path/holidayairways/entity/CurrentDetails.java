package com.path.holidayairways.entity;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Current_Details")
public class CurrentDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="FlightNo",length=7)
	private String flightNo;
	
	@Column(name="Category",length=5,nullable=false)
	private String category;
	
	@Column(name="Available_Seats",nullable=false,columnDefinition="NUMBER")
	private Integer availableSeats;
	
	@Column(name="Date_of_Departure",nullable=false)
	private Date departureDate;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private FlightMaster flMaster;
	
	
	
	

}
