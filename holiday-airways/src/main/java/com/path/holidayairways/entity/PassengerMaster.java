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
@Table(name="Passenger_Master")
public class PassengerMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Res_No",columnDefinition="NUMBER")
	private Integer resNo;//Reservation Number of passenger
	
	@Column(name="Res_Date",nullable=false)
	private Date res_date;
	
	
	@Column(name="Flight_No",length=7,nullable=false)
	private String flightNo;
	
	@Column(name="Departure_Date",nullable=false)
	private Date departureDate;
	
	@Column(name="Address",nullable=false,length=30)
	private String address;
	
	@Column(name="State",nullable=false,length=20)
	private String state;
	
	@Column(name="PhoneNo")
	private Integer phoneNo;
	
	@Column(name="Email_Address",length=20)
	private String emailAddress;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private FlightMaster flMaster;
	
	
	
	
	

}
