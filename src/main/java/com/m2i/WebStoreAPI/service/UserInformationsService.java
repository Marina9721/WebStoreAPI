package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.UserInformations;
import com.m2i.WebStoreAPI.repository.UserInformationsRepository;

@Service
public class UserInformationsService {

	@Autowired
	UserInformationsRepository repo;
	
	public void create(UserInformations ui) {
		repo.save(ui);
	}

	public UserInformations getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<UserInformations> getAll() {
		return repo.findAll();
	}

	public void update(int id, UserInformations ui) {
		UserInformations userInformations = repo.findById(id).orElse(null);
		if (ui!= null) {
			userInformations.setAddress( ui.getAddress() );
			userInformations.setCity( ui.getCity());
			userInformations.setEmail( ui.getEmail());
			userInformations.setPhoneNumber( ui.getPhoneNumber() );
			userInformations.setUser( ui.getUser() );
			repo.save(userInformations);
		}
	}

	public void delete(int id) {
		UserInformations userInformations = repo.findById(id).orElse(null);
		if (userInformations!= null) {
			repo.delete(userInformations);
		}
		
	}

}