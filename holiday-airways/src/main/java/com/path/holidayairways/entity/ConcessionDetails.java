package com.path.holidayairways.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Concession_Details")
@AllArgsConstructor
@NoArgsConstructor
public class ConcessionDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Type",length=10)
	private String type;
	
	@Column(name="Age",columnDefinition="NUMBER",nullable=false)
	private Integer age;
	
	@Column(name="Pass_No",nullable=false)
	private Integer passNo;
	
	@Column(name="Concession_Amt",columnDefinition="NUMBER(7,2)",nullable=false)
	private Double concessionAmt;
	
	@Column(name="Res_No",columnDefinition="NUMBER")
	private Integer resNo;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private ConcessionMaster conMaster;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PassengerDetails passDetails;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PassengerMaster pasMaster;
	
	

}
