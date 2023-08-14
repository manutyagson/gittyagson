package com.path.holidayairways.entity;

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

@Entity
@Table(name="Passenger_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name="Pass_No",columnDefinition="NUMBER")
	private Integer passNo;
	
	@Column(name="Pass_Name",length=20,nullable=false)
	private String passName;
	
	@Column(name="Gender",nullable=false)
	private char gender;
	
	@Column(name="Age",columnDefinition="NUMBER",nullable=false)
	private Integer age;
	
	@Column(name="Passport_No",length=20)
	private String passportNo;
	
	@Column(name="VisaType",length=20)
	private String visaType;
	
	@Column(name="Res_No",columnDefinition="NUMBER")
	private Integer resNo;
	
	@Column(name="Confirmed",nullable=false)
	private boolean confirmed;
	
	@Column(name="Seat_No")
	private Integer seatNo;
	
	@Column(name="Cost",columnDefinition="NUMBER(8,2)",nullable=false)
	private Double cost;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PassengerMaster passMaster;
	
	


}
