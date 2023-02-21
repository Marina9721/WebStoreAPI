package com.m2i.WebStoreAPI.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CreditCardPayment")
@PrimaryKeyJoinColumn(name="idPayment")
@Getter @Setter
@ToString
public class CreditCardPayment extends Payment {
	
	@Column(name="cardNumber")
	private String cardNumber;
	
	@Column(name="expirationDate")
	private Date expirationDate;

	public CreditCardPayment() {
		super();
	}

}
