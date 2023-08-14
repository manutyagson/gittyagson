package com.path.holidayairways.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Cancellation")
public class Cancellation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Cancel_No",columnDefinition="NUMBER")
	private Integer cancelNo;
	
	@Column(name="Cancel_Date",nullable=false)
	private Date cancelDate;
	
	@Column(name="Code",columnDefinition="NUMBER")
	private Integer code;
	
	@Column(name="Flight_No",length=20)
	private String flightNo;
	
	@Column(name="Res_No",columnDefinition="NUMBER")
	private Integer resNo;
	
	@Column(name="Cancellation_Amt",columnDefinition="NUMBER(8,2)",nullable=false)
	private Double cancellationAmt;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="c_code")
	private CancellationMaster csMaster;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="flNo")
	private PassengerMaster psFlMaster;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="rsNo")
	private PassengerMaster psRsMaster;
	

}
