package com.m2i.WebStoreAPI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="credit_card_payment")
@Getter @Setter @ToString @AllArgsConstructor
public class CreditCardPayment extends Payment {
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="expiration_date")
	private Date expirationDate;
	
	public CreditCardPayment() {
		
		Faker f = new Faker();
		
		this.amount = f.number().numberBetween(1, 300);
		this.paymentDate = f.date().birthday();
		this.cardNumber = Integer.toString(f.number().numberBetween(10000, 99999));
		this.expirationDate = f.date().birthday();

	}


}
