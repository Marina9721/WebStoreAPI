package com.m2i.WebStoreAPI.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity() @Table(name="articles")
@Getter @Setter @AllArgsConstructor @ToString
public class Article {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Getter @Setter
	private String description;
	
	@Getter @Setter
	private String brand;
	
	@Getter @Setter
	private double price;
	
	@OneToMany(targetEntity = CommandLine.class, mappedBy="article")
	@JsonIgnore
	private List<CommandLine> commandLines;
	
	
	public Article() {
		Faker f = new Faker();
		
		this.description = f.lorem().paragraph();
		this.brand = f.company().name();
		this.price = f.number().randomDouble(2, 10, 1000);
	}


	public Article(String description, String brand, double price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	

}
