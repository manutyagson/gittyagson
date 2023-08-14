package com.path.holidayairways.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Flight_Admin")
public class FlightAdmin {
	
	@Id
	@Column(name="admin_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="First_Name",length=23,nullable=false)
	private String firstName;
	
	@Column(name="Last_Name",length=23,nullable=false)
	private String lastName;
	
	@Column(name="Email_Address",length=30,nullable=false)
	private String emailAddress;
	
	@Column(name="Password",nullable=false)
	private String password;
	
	@Column(name="Register_As",length=45,nullable=false)
	private String registerAs;
	
	@Column(name="IpAddress")
	private String ipAddress;
	
	@Column(name="Created_On")
	@CreationTimestamp
	private LocalDate createdOn;
	
	@Column(name="Created_By")
	private String createdBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterAs() {
		return registerAs;
	}

	public void setRegisterAs(String registerAs) {
		this.registerAs = registerAs;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	

}
