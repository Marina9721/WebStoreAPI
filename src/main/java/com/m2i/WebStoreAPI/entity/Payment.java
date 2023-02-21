package com.m2i.WebStoreAPI.entity;

import java.sql.Date;

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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table
@Getter @Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@JsonDeserialize(as = PaypalPayment.class)
public abstract class Payment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private float amount;
	private Date paymentDate;
	
	@OneToOne @JoinColumn(name="id_command")
	private Command command;

	public Payment() {
		super();
	}

}
