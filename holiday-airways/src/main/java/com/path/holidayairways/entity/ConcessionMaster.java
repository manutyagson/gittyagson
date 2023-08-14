package com.path.holidayairways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Concession_Master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcessionMaster {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Type",length=10)
	private String type;
	
	@Column(name="Percentage",nullable=false,columnDefinition="NUMBER(2)")
	private Integer percentage;
	
	@Column(name="Description",length=20)
	private String description;
}
