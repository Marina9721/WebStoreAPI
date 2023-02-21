package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.UserInformations;
import com.m2i.WebStoreAPI.repository.UserInformationsRepository;

@Service
public class UserInformationsService {

	@Autowired
	UserInformationsRepository repo1;
	
	public void create(UserInformations u) {
		repo1.save(u);
	}

	public UserInformations getById(int id) {
		return repo1.findById(id).orElse(null);
	}

	public List<UserInformations> getAll() {
		return repo1.findAll();
	}

	public void update(int id, UserInformations u) {
		UserInformations userInformations = repo1.findById(id).orElse(null);
		if (u!= null) {
			userInformations.setAddress( u.getAddress() );
			userInformations.setCity( u.getCity());
			userInformations.setEmail( u.getEmail());
			userInformations.setPhoneNumber( u.getPhoneNumber() );
			userInformations.setUser( u.getUser() );
			repo1.save(userInformations);
		}
	}

	public void delete(int id) {
		UserInformations userInformations = repo1.findById(id).orElse(null);
		if (userInformations!= null) {
			repo1.delete(userInformations);
		}
		
	}

}