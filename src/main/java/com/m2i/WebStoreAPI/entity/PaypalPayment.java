package com.m2i.WebStoreAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PaypalPayment")
@PrimaryKeyJoinColumn(name="idPayment")
@Getter @Setter @ToString
public class PaypalPayment extends Payment {
	
	@Column(name="accountNumber")
	private String AccountNumber;

	public PaypalPayment() {
		super();
	}		

}
