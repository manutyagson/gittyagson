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
@Table(name="Flight_Desc")
public class FlightDesc {

	@Id
	@Column(name="Flight_No",length=7)
	private String flightNo;

	@Column(name="Category",length=5,nullable=false)
	private String category;
	
	@Column(name="Cost_of_Ticket",columnDefinition="NUMBER(8,2)",nullable=false)
	private Double ticketCost;
	
	@Column(name="Starting_SeatNo",columnDefinition="NUMBER",nullable=false)
	private Integer startingSeatNo;
	
	@Column(name="Ending_SeatNo",columnDefinition="NUMBER",nullable=false)
	private Integer endingSeatNo;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private FlightMaster flMaster;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Integer getStartingSeatNo() {
		return startingSeatNo;
	}

	public void setStartingSeatNo(Integer startingSeatNo) {
		this.startingSeatNo = startingSeatNo;
	}

	public Integer getEndingSeatNo() {
		return endingSeatNo;
	}

	public void setEndingSeatNo(Integer endingSeatNo) {
		this.endingSeatNo = endingSeatNo;
	}

	public FlightMaster getFlMaster() {
		return flMaster;
	}

	public void setFlMaster(FlightMaster flMaster) {
		this.flMaster = flMaster;
	}
	
	

}