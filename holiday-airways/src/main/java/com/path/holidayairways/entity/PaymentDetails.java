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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Payment_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Invoice_No",columnDefinition="NUMBER")
	private Integer invoiceNo;
	
	@Column(name="Res_No",columnDefinition="NUMBER")
	private Integer resNo;
	
	@Column(name="Mode_Payment",length=2,nullable=false)
	private String modePayment;
	
	@Column(name="Amount",columnDefinition="NUMBER(10,2)",nullable=false)
	private Double amount;
	
	@Column(name="Card_Type",length=10)
	private String cardType;
	
	@Column(name="Card_No",columnDefinition="NUMBER(10)")
	private Integer cardNo;
	
	@Column(name="Card_holder_Name",length=20)
	private String cardHolderName;
	
	@Column(name="Expiry_date")
	private Date expiryDate;
	
	@Column(name="Cheque_No",columnDefinition="NUMBER(6)")
	private Integer chequeNo;
	
	@Column(name="Cheque_Date")
	private Date chequeDate;
	
	@Column(name="Bank_Drawn",length=10)
	private String bankDrawn;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="r_no")
	private PassengerMaster psMaster;
	
	
	

}
