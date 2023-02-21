package com.m2i.WebStoreAPI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="payments")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonDeserialize(as = PaypalPayment.class)
public abstract class Payment {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private double amount;
	private Date paymentDate;
	
	@OneToOne @JoinColumn(name="id_command", nullable=false)
	private Command command;
	

	public Payment(double amount, Date paymentDate, Command command) {
		super();
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.command = command;
	}

}
