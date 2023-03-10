package com.m2i.WebStoreAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="paypal_payment")
@Getter @Setter @ToString @AllArgsConstructor
public class PaypalPayment extends Payment {
	
	@Column(name="account_number")
	private String accountNumber;
	
	
	public PaypalPayment() {
		
		Faker f = new Faker();
		
		this.amount = f.number().numberBetween(1, 300);
		this.paymentDate = f.date().birthday();
		this.accountNumber = Integer.toString(f.number().numberBetween(100000, 999999));
	}		

}
