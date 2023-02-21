package com.m2i.WebStoreAPI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="credit_card_payment")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class CreditCardPayment extends Payment {
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="expiration_date")
	private Date expirationDate;


}
