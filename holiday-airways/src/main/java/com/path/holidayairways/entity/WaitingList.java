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
@Entity
@Table(name="Waiting_List")
@NoArgsConstructor
@AllArgsConstructor
public class WaitingList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Pass_No",columnDefinition="NUMBER")
	private Integer passNo;
	
	@Column(name="Flight_No",length=7)
	private String flightNo;
	
	@Column(name="Date_of_Departure",nullable=false)
	private Date departureDate;
	
	@Column(name="Category",nullable=false,length=5)
	private String category;
	
	@Column(name="Waiting_No",nullable=false,length=7)
	private String waitingNo;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PassengerMaster psMaster;
	

}
