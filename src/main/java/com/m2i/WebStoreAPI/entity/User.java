package com.m2i.WebStoreAPI.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="users")
@Getter @Setter @AllArgsConstructor @ToString
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	
	private String password;
	
	private int connectionNumber;
	
	@OneToOne(targetEntity= UserInformations.class, mappedBy="user" , cascade = CascadeType.ALL, 
			orphanRemoval = true)
    private UserInformations userInformations;
	
	@ManyToMany
	@JoinTable(name = "user_role_association",
			joinColumns = @JoinColumn(name="id_user"),
			inverseJoinColumns = @JoinColumn(name="id_role"))
	private List<Role> roles;
	
	
	
	public User() {
		Faker f = new Faker();
		
		this.login = f.name().username();
		
		this.password = f.internet().password();
		
		this.connectionNumber = f.number().numberBetween(0, 1000000);
		
	}
}