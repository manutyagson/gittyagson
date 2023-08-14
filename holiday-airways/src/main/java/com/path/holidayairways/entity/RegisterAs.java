package com.path.holidayairways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="RegisterAs")

public class RegisterAs {
	
	@Id
	@Column(name="RegisterAs")
	private String registerAs;

	public String getRegisterAs() {
		return registerAs;
	}

	public void setRegisterAs(String registerAs) {
		this.registerAs = registerAs;
	}
	
	

}
