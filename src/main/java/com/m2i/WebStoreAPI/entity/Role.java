package com.m2i.WebStoreAPI.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="roles")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String roleName;	
	
	@ManyToMany
	@JoinTable(name = "user_role_association",
			joinColumns = @JoinColumn(name="id_role"),
			inverseJoinColumns = @JoinColumn(name="id_user"))
	private List<User> users;
	
	public Role(List<User> users) {
		super();
		
		this.users = new ArrayList<>();
	}
	

}
