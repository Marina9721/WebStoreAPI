package com.m2i.WebStoreAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table
@Getter @Setter @AllArgsConstructor @ToString
public class CommandLine {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Getter @Setter
	private int quantity;
	
	@ManyToOne @JoinColumn(name="id_article")
	private Article article;
	
	@ManyToOne @JoinColumn(name="id_command")
	private Command command;
	
	public CommandLine() {
		Faker f = new Faker();
		
		this.quantity = f.number().randomDigit();
	}

}
