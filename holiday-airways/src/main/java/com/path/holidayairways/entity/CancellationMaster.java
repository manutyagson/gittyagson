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

@Data
@Entity
@Table(name="Cancellation_Master")
@NoArgsConstructor
@AllArgsConstructor
public class CancellationMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Code",columnDefinition="NUMBER")
	private Integer code;
	
	@Column(name="Description",length=10,nullable=false)
	private String description;
	
	@Column(name="Percentage",columnDefinition="NUMBER(2)",nullable=false)
	private Integer percentage;

}
